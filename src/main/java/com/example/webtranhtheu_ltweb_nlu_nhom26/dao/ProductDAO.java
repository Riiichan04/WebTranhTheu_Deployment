package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class ProductDAO {
    //Lấy thông tin sản phẩm
    public static Product getProductById(int id) {
        Product product = getProductBasicInfo(id);
        if (product == null) return null;
        //Xử lý NullPointerException
        product.setPolicies(getProductPolicy(id));
        product.getListPrice().addAll(getProductPrices(id));
        product.getListMaterial().addAll(getMaterials(id));
        product.getListImageUrl().addAll(getImageUrls(id));
        product.getListReview().addAll(getProductReviews(id, 0)); //Mặc định offset = 0
        product.getListDiscount().addAll(getProductDiscounts(id));

        return product;
    }

    //Lấy thông tin cơ bản của sản phẩm
    private static Product getProductBasicInfo(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("""
                                select products.title, products.code, products.description, products.typeOfProduct
                                from products
                                join category_product_details
                                    on products.id = category_product_details.productId
                                join product_images
                                    on product_images.productId = products.id
                                where products.id = :id
                                """)
                        .bind("id", id).map((rs, ctx) -> {
                            Product product = new Product();
                            product.setId(id);
                            product.setCode(rs.getString("code"));
                            product.setTitle(rs.getString("title"));
                            product.setDescription(rs.getString("description"));
                            product.setType(ProductType.getTypeByValue(rs.getInt("typeOfProduct")));

                            return product;
                        }).one()
        );
    }

    //Lấy nhà cung cấp của sản phẩm
    private static Provider getProductProvider(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select providers.* from providers " +
                                "join products on providers.id = products.providerId " +
                                "where products.id = :id")
                        .bind("id", id)
                        .mapToBean(Provider.class).one()
        );
    }

    // Lấy giá tiền của sản phẩm theo mọi kích thước
    private static List<ProductPrice> getProductPrices(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select price, width, height from product_prices where productId = :id")
                        .bind("id", id)
                        .mapToBean(ProductPrice.class)
                        .list()
        );
    }

    // Lấy danh sách chính sách hiện có của sản phẩm
    private static ProductPolicy getProductPolicy(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select policies.title, policies.description " +
                                "from policies join products on policies.id = products.policyId " +
                                "where product.id = :id")
                        .bind("id", id)
                        .mapToBean(ProductPolicy.class)
                        .one()
        );
    }

    // Lấy danh sách nguyên liệu của sản phẩm
    private static List<Material> getMaterials(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select materials.name " +
                                "from product_materials join materials on product_materials.materialId = materials.id " +
                                "where productId = :id")
                        .bind("id", id)
                        .mapToBean(Material.class)
                        .list()
        );
    }

    //Lấy danh sách hình ảnh của sản phẩm
    private static List<String> getImageUrls(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select img_url from product_images where productId = :id")
                        .bind("id", id)
                        .mapToBean(String.class)
                        .list()
        );
    }

    //Lấy danh sách review của sản phẩm
    private static List<ProductReview> getProductReviews(int id, int offset) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select accountId, rating, content " +
                                "from product_reviews " +
                                "where productId = :id and content is not null " +
                                "limit :offset, 5")
                        .bind("id", id)
                        .bind("offset", offset)
                        .mapToBean(ProductReview.class).list()
        );
    }

    //Lấy danh sách chương trình giảm giá đang được áp dụng cho sản phẩm
    private static List<ProductDiscount> getProductDiscounts(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select discounts.title, discounts.description, discounts.startedAt, discounts.endedAt" +
                                "from discounts " +
                                "join product_discounts_details on discounts.id = product_discounts_details.discountId" +
                                "join products where product_discounts_details.productId = products.id" +
                                "where discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
                        .bind("id", id)
                        .mapToBean(ProductDiscount.class).list()
        );
    }


    //Chọn cách nào để làm ???
    interface ProductQueries {
        @SqlQuery("select products.title, products.code, products.description, products.typeOfProduct from products join category_product_details on products.id = category_product_details.productId join product_images on product_images.productId = products.id where products.id = :id")
        Product getProductBasicInfo(@Bind("id") int id);    //Có thể bỏ vì Map cái này khó

        @SqlQuery("select providers.* from providers join products on providers.id = products.providerId where products.id = :id")
        Provider getProductProvider(@Bind("id") int id);
    }
}
