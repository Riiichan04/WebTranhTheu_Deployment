package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.BaseProductMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface ProductDAO {

    @SqlQuery("select products.id, products.title, products.codeProduct, products.description, products.typeOfProduct, products.createdAt, products.updatedAt from products join category_products_details on products.id = category_products_details.productId where products.id = :id")
    @RegisterRowMapper(BaseProductMapper.class)
    Product getProductInfo(@Bind("id") int id);

    @SqlQuery("select categories.* from categories join category_products_details on categories.id = category_products_details.categoryId where category_products_details.productId = :id")
    @RegisterBeanMapper(Category.class)
    Category getCategory(@Bind("id") int id);

    @SqlQuery("select imgUrl from product_images where productId = :id limit 1")
    String getThumbnail(@Bind("id") int id);

    @SqlQuery("select providers.id, providers.providerName, addresses.location, providers.createdAt, providers.updatedAt from providers join products on providers.id = products.providerId join addresses on providers.addressId = addresses.id where products.id = :id")
    @RegisterBeanMapper(Provider.class)
    Provider getProductProvider(@Bind("id") int id);

    @SqlQuery("select policies.title, policies.description, policies.createdAt, policies.updatedAt from policies join products on policies.id = products.policyId where products.id = :id")
    @RegisterBeanMapper(Policy.class)
    Policy getProductPolicy(@Bind("id") int id);

    @SqlQuery("select topics.id, topics.title, topics.active, topics.createdAt, topics.updatedAt from topics join topic_products_details on topic_products_details.topicId = topics.id where topic_products_details.productId = :id")
    @RegisterBeanMapper(Topic.class)
    List<Topic> getTopics(@Bind("id") int id);

    @SqlQuery("select imgUrl from product_images where productId = :id")
    List<String> getListImageUrls(@Bind("id") int id);

    @SqlQuery("select productId, width, height, price, available from product_prices where productId = :id")
    @RegisterBeanMapper(Price.class)
    List<Price> getProductPrices(@Bind("id") int id);

    @SqlQuery("select materials.title, materials.createdAt, materials.updatedAt from material_products_details join materials on material_products_details.materialId = materials.id where productId = :id")
    @RegisterBeanMapper(Material.class)
    List<Material> getMaterials(@Bind("id") int id);

    @SqlQuery("select accountId, rating, content, createdAt, updatedAt from product_reviews where productId = :id and content is not null limit :offset, 5")
    @RegisterBeanMapper(Review.class)
    List<Review> getProductReviews(@Bind("id") int id, @Bind("offset") int offset);

    @SqlQuery("select discounts.title, discounts.description, discounts.createdAt, discounts.updatedAt, discounts.startedAt, discounts.endedAt from discounts join product_discounts_details on discounts.id = product_discounts_details.discountId join products where product_discounts_details.productId = products.id and discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
    @RegisterBeanMapper(Discount.class)
    List<Discount> getProductDiscounts(@Bind("id") int id);

//    default Product getProductInfo(int productId) {
//        return JDBIConnector.getInstance().withHandle(handle -> handle
//                .createQuery("""
//                        select products.id products.title, products.code, products.description, products.typeOfProduct
//                        from products
//                        join category_product_details
//                            on products.id = category_product_details.productId
//                        where products.id = :id
//                        """)
//                .bind("id", productId).map((rs, ctx) -> {
//                    Product product = new Product();
//                    product.setId(productId);
//                    product.setCode(rs.getString("code"));
//                    product.setTitle(rs.getString("title"));
//                    product.setDescription(rs.getString("description"));
//                    product.setType(rs.getInt("typeOfProduct"));
//                    return product;
//                }).one()
//        );
//    }
//
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
//                handle.createQuery("select imgUrl from product_images where productId = :id")
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

    @SqlQuery("select id, codeProduct as code, title from products")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsCodeAndTitle();
}
