package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class FullProductDAO extends DecorationProductDAO {

    public FullProductDAO(ProductDAO wrapper) {
        super(wrapper);
    }

    public Product getFullProductInfo(int productId) {
        Product product = super.getProductInfo(productId);
        product.setPolicy(getProductPolicy(productId));
        product.getListPrices().addAll(getProductPrices(productId));
        product.getListMaterials().addAll(getMaterials(productId));
        product.getListImageUrls().addAll(getImageUrls(productId));
        product.getListReviews().addAll(getProductReviews(productId, 0)); //Mặc định offset = 0
        product.getListDiscounts().addAll(getProductDiscounts(productId));
        return product;
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
    private static List<Price> getProductPrices(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select price, width, height from product_prices where productId = :id")
                        .bind("id", id)
                        .mapToBean(Price.class)
                        .list()
        );
    }

    // Lấy danh sách chính sách hiện có của sản phẩm
    private static Policy getProductPolicy(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select policies.title, policies.description " +
                                "from policies join products on policies.id = products.policyId " +
                                "where product.id = :id")
                        .bind("id", id)
                        .mapToBean(Policy.class)
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
    private static List<Review> getProductReviews(int id, int offset) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select accountId, rating, content " +
                                "from product_reviews " +
                                "where productId = :id and content is not null " +
                                "limit :offset, 5")
                        .bind("id", id)
                        .bind("offset", offset)
                        .mapToBean(Review.class).list()
        );
    }

    //Lấy danh sách chương trình giảm giá đang được áp dụng cho sản phẩm
    private static List<Discount> getProductDiscounts(int id) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select discounts.title, discounts.description, discounts.startedAt, discounts.endedAt" +
                                "from discounts " +
                                "join product_discounts_details on discounts.id = product_discounts_details.discountId" +
                                "join products where product_discounts_details.productId = products.id" +
                                "where discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
                        .bind("id", id)
                        .mapToBean(Discount.class).list()
        );
    }
}
