package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.BaseProductMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
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

    @SqlQuery("select productId, accountId, rating, content, createdAt, updatedAt from product_reviews where productId = :id and content is not null limit :offset, :amount")
    @RegisterBeanMapper(Review.class)
    List<Review> getProductReviews(@Bind("id") int id, @Bind("offset") int offset, @Bind("amount") int amount);

    @SqlQuery("select discounts.title, discounts.description, discounts.createdAt, discounts.updatedAt, discounts.startedAt, discounts.endedAt from discounts join product_discounts_details on discounts.id = product_discounts_details.discountId join products where product_discounts_details.productId = products.id and discounts.startedAt <= now() and discounts.endedAt >= now() and products.id = :id")
    @RegisterBeanMapper(Discount.class)
    List<Discount> getProductDiscounts(@Bind("id") int id);

    @SqlQuery("select products.id from products join (select order_products_details.productId from order_products_details join orders on order_products_details.orderId = orders.id where orders.createdAt >= now() - interval 3 month and order_products_details.productId in (select productId from order_products_details group by productId order by count(productId))) as limit_orders on limit_orders.productId = products.id limit 5")
    List<Integer> getIdOfHotProduct();

    //Lấy danh sách các product có đánh giá cao nhất
    @SqlQuery("select products.id from products join ( select productId, avg(rating) as rating from product_reviews group by productId order by rating desc limit 5) as product_ratings on product_ratings.productId = products.id")
    List<Integer> getMostRatedProductsId();

    @SqlQuery("select count(id) from products")
    int countProducts();

    @SqlQuery("select count(id) from product_reviews where productId = :id")
    int countReviews(@Bind("id") int id);

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

    //    public List<Object> getHotProducts() {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select products.title, product_prices.price, product_ratings.rating, images.productId\n" +
//                        "from products \n" +
//                        "  join category_product_details\n" +
//                        "    on products.id = category_product_details.productId\n" +
//                        "\n" +
//                        "  right join product_prices\n" +
//                        "    on products.id = product_prices.productId\n" +
//                        "\n" +
//                        "  join (\n" +
//                        "    select productId, avg(rating) as rating\n" +
//                        "    from product_reviews\n" +
//                        "    group by productId\n" +
//                        "  ) \n" +
//                        "  as product_ratings\n" +
//                        "    on product_ratings.productId = products.id\n" +
//                        "    \n" +
//                        "  left join (\n" +
//                        "    select productId, img_url\n" +
//                        "    from product_images\n" +
//                        "    limit 1\n" +
//                        "  ) as images on products.id = images.productId\n" +
//                        "\n" +
//                        "  join (\n" +
//                        "    select order_products_details.productId\n" +
//                        "    from orders_products_details join orders\n" +
//                        "      on orders_products_details.orderId = orders.id\n" +
//                        "    where \n" +
//                        "      orders.createdAt >= now() - interval 3 month\n" +
//                        "      and order_products_details.productId in (\n" +
//                        "        select productId \n" +
//                        "        from order_products_details\n" +
//                        "        group by productId \n" +
//                        "        order by count(productId)\n" +
//                        "        limit 5\n" +
//                        "    ) as limit_orders on limit_orders.productId = products.id\n" +
//                        "limit 5\n").mapToBean(Object.class).list()
//        );
//    }
//
//    //Lấy danh sách các product có đánh giá cao nhất
//    public List<Product> getMostRatedProducts() {
//        List<Integer> listProductId = JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select products.id" +
//                                "from products" +
//                                "join (" +
//                                "  select productId, avg(rating) as rating" +
//                                "  from product_reviews" +
//                                "  group by productId" +
//                                "  order by rating desc" +
//                                "  limit 5)" +
//                                "as product_ratings" +
//                                "  on product_ratings.productId = products.id")
//                        .mapToBean(Integer.class).list());
//
//        List<Product> listProduct = new ArrayList<>();
//        for (int id : listProductId) {
//            listProduct.add(getProductById(id));
//        }
//        return listProduct;
//    }

    @SqlQuery("select id from products join category_products_details on products.id = category_products_details.productId where id != :id and category_products_details.categoryId = :categoryId order by rand() limit 5")
    List<Integer> getSimilarProductId(@Bind("id") int id, @Bind("categoryId") int categoryId);

    @SqlUpdate("""
        insert into product_reviews(productId, accountId, rating, content, createdAt, updatedAt)
        values(:accountId, :productId, :rating, :content, :createdAt, :updatedAt)
    """)
    int insertReview(@Bind("accountId") int accountId, @Bind("productId") int productId, @Bind("rating") int rating, @Bind("content") String content, @Bind("createdAt") Timestamp createdAt, @Bind("updatedAt") Timestamp updatedAt);

    @SqlQuery("""
                select ifnull(count(orders.accountId) > reviews.count_review, 1) as result
                from orders
                join order_products_details
                on orders.id = order_products_details.orderId
                join (
                    select count(accountId) as count_review, accountId
                    from product_reviews
                    where accountId = :accountId and productId = :productId
                    group by accountId
                ) as reviews
                on reviews.accountId = orders.accountId
                where orders.accountId = :accountId and order_products_details.productId = :productId
    """)
    boolean isUserCanReview(@Bind("accountId") int accountId, @Bind("productId") int productId);

    @SqlQuery("""
        select avg(rating)
        from product_reviews
        where productId = :productId
    """)
    double getProductRating(@Bind("productId") int productId);

    @SqlQuery("""
        select products.id
        from products join topic_products_details on products.id = topic_products_details.productId
        where topic_products_details.topicId in (<topicIds>) and products.id != :productId
        limit 4
    """)
    List<Integer> findAllSimilarProducts(@BindList("topicIds") List<Integer> topicIds, @Bind("productId") int productId);
}
