package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface ProductDAO {
    default Product getProductInfo(int productId) {
        return JDBIConnector.getInstance().withHandle(handle -> handle
                .createQuery("""
                        select products.title, products.code, products.description, products.typeOfProduct
                        from products
                        join category_product_details
                            on products.id = category_product_details.productId
                        where products.id = :id
                        """)
                .bind("id", productId).map((rs, ctx) -> {
                    Product product = new Product();
                    product.setId(productId);
                    product.setCode(rs.getString("code"));
                    product.setTitle(rs.getString("title"));
                    product.setDescription(rs.getString("description"));
                    product.setType(rs.getInt("typeOfProduct"));
                    return product;
                }).one()
        );
    }

    @SqlQuery("select img_url from product_images where productId = :id limit 1")
    String getThumbnail(@Bind("id") int id);

    @SqlQuery("select imgUrl from product_images where productId = :id")
    List<String> getListImageUrls(@Bind("id") int id);

    @SqlQuery("select providers.* from providers join products on providers.id = products.providerId where products.id = :id")
    Provider getProductProvider(@Bind("id") int id);

    @SqlQuery("select price, width, height from product_prices where productId = :id")
    List<Price> getProductPrices(@Bind("id") int id);

    @SqlQuery("select policies.title, policies.description from policies join products on policies.id = products.policyId where product.id = :id")
    Policy getProductPolicy(@Bind("id") int id);

    @SqlQuery("select materials.name from product_materials join materials on product_materials.materialId = materials.id where productId = :id")
    List<Material> getMaterials(@Bind("id") int id);

    @SqlQuery("select accountId, rating, content from product_reviews where productId = :id and content is not null limit :offset, 5")
    List<Review> getProductReviews(@Bind("id") int id, @Bind("offset") int offset);

    @SqlQuery("select discounts.title, discounts.description, discounts.startedAt, discounts.endedAt from discounts join product_discounts_details on discounts.id = product_discounts_details.discountId join products where product_discounts_details.productId = products.id where discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
    List<Discount> getProductDiscounts(@Bind("id") int id);

//    //Lấy nhà cung cấp của sản phẩm
//    private static Provider getProductProvider(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select providers.* from providers " +
//                                "join products on providers.id = products.providerId " +
//                                "where products.id = :id")
//                        .bind("id", id)
//                        .mapToBean(Provider.class).one()
//        );
//    }
//
//    // Lấy giá tiền của sản phẩm theo mọi kích thước
//    private static List<Price> getProductPrices(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select price, width, height from product_prices where productId = :id")
//                        .bind("id", id)
//                        .mapToBean(Price.class)
//                        .list()
//        );
//    }
//
//    // Lấy danh sách chính sách hiện có của sản phẩm
//    private static Policy getProductPolicy(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select policies.title, policies.description " +
//                                "from policies join products on policies.id = products.policyId " +
//                                "where product.id = :id")
//                        .bind("id", id)
//                        .mapToBean(Policy.class)
//                        .one()
//        );
//    }
//
//    // Lấy danh sách nguyên liệu của sản phẩm
//    private static List<Material> getMaterials(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select materials.name " +
//                                "from product_materials join materials on product_materials.materialId = materials.id " +
//                                "where productId = :id")
//                        .bind("id", id)
//                        .mapToBean(Material.class)
//                        .list()
//        );
//    }
//
//    //Lấy danh sách hình ảnh của sản phẩm
//    private static List<String> getImageUrls(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select img_url from product_images where productId = :id")
//                        .bind("id", id)
//                        .mapToBean(String.class)
//                        .list()
//        );
//    }
//
//    //Lấy danh sách review của sản phẩm
//    private static List<Review> getProductReviews(int id, int offset) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select accountId, rating, content " +
//                                "from product_reviews " +
//                                "where productId = :id and content is not null " +
//                                "limit :offset, 5")
//                        .bind("id", id)
//                        .bind("offset", offset)
//                        .mapToBean(Review.class).list()
//        );
//    }
//
//    //Lấy danh sách chương trình giảm giá đang được áp dụng cho sản phẩm
//    private static List<Discount> getProductDiscounts(int id) {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select discounts.title, discounts.description, discounts.startedAt, discounts.endedAt" +
//                                "from discounts " +
//                                "join product_discounts_details on discounts.id = product_discounts_details.discountId" +
//                                "join products where product_discounts_details.productId = products.id" +
//                                "where discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
//                        .bind("id", id)
//                        .mapToBean(Discount.class).list()
//        );
//    }
}
