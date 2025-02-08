package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.ArrayList;
import java.util.List;

public class ConcreteProductDetail implements ProductDetailService {
    ProductDAO productDAO;

    public ConcreteProductDetail() {
        this.productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    //Dùng để hiển thị thông tin product dưới dạng card
    @Override
    public Product getProductInfo(int productId) {
        return productDAO.getProductInfo(productId);
    }

    //Đây là method tạm
    public int countProducts() {
        return productDAO.countProducts();
    }

    public int countReviews(int id) {
        return productDAO.countReviews(id);
    }

    public boolean isUserCanReview(int productId, int userId) {
        return productDAO.isUserCanReview(productId, userId);
    }

    //Đây là method tạm, sau này sẽ tách sang review
    public boolean uploadReview(Review review) {
        return productDAO.insertReview(review.getAccountId(), review.getProductId(), review.getRating(), review.getContent(), review.getCreatedAt(), review.getUpdatedAt()) != 0;
    }

    public double getProductRating(int productId) {
        return productDAO.getProductRating(productId);
    }

    public List<Integer> filterProduct(String categoryName, List<Integer> listTopicId, int rating, double fromPrice, double toPrice, String providerName, String productName, int offset, int amount) {
        String query = """
                select distinct products.id
                from products
                join category_products_details
                    on products.id = category_products_details.productId
                join categories
                    on category_products_details.categoryId = categories.id
                join topic_products_details
                    on products.id = topic_products_details.productId
                join product_prices
                    on products.id = product_prices.productId
                left join product_reviews
                    on products.id = product_reviews.productId
                join providers
                    on products.providerId = providers.id
                where (:patternName is null or categories.patternName like :patternName)
        """;

        if (listTopicId != null) {
            query += "and (topic_products_details.topicId in (<topicId>))";
        }
        query += """
                and (:providerName is null or providers.providerName like :providerName)
                and ((:fromPrice = 0 and :toPrice = 0) or :fromPrice <= :toPrice and product_prices.price between :fromPrice and :toPrice)
                and (:productName is null or products.title like :productName)
            group by products.id
            having (:rating = 0 or coalesce(avg(product_reviews.rating), 0) >= :rating)
            order by products.id
            limit :offset, :amount
        """;

        String finalQuery = query;
        System.out.println("Final Query: " + finalQuery);
        try {
            if (listTopicId != null) {
                return JDBIConnector.getInstance().withHandle(handle ->
                        handle.createQuery(finalQuery)
                                .bind("patternName", categoryName)
                                .bindList("providerName", listTopicId)
                                .bind("providerName", providerName)
                                .bind("fromPrice", fromPrice)
                                .bind("toPrice", toPrice)
                                .bind("rating", rating)
                                .bind("productName", productName)
                                .bind("offset", (offset - 1) * amount)
                                .bind("amount", amount)).mapTo(Integer.class).list();
            }
            else {
                return JDBIConnector.getInstance().withHandle(handle ->
                        handle.createQuery(finalQuery)
                                .bind("patternName", categoryName)
                                .bind("providerName", providerName)
                                .bind("fromPrice", fromPrice)
                                .bind("toPrice", toPrice)
                                .bind("rating", rating)
                                .bind("productName", productName)
                                .bind("offset", (offset - 1) * amount)
                                .bind("amount", amount)).mapTo(Integer.class).list();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
//        return productDAO.filterProduct(categoryName, listTopicId, rating, fromPrice, toPrice, providerName, productName, (offset - 1) * amount, amount);
    }

    public List<Integer> findProductsIdByName(String productName, int page, int amount) {
        return productDAO.findProductsIdByName("%" + productName + "%", (page - 1) * amount, amount);
    }
}
