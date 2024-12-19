package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class ProductDAO {
    //Tạm
    public List<Object> getHotProducts() {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select products.title, product_prices.price, product_ratings.rating, images.productId\n" +
                        "from products \n" +
                        "  join category_product_details\n" +
                        "    on products.id = category_product_details.productId\n" +
                        "\n" +
                        "  right join product_prices\n" +
                        "    on products.id = product_prices.productId\n" +
                        "\n" +
                        "  join (\n" +
                        "    select productId, avg(rating) as rating\n" +
                        "    from product_reviews\n" +
                        "    group by productId\n" +
                        "  ) \n" +
                        "  as product_ratings\n" +
                        "    on product_ratings.productId = products.id\n" +
                        "    \n" +
                        "  left join (\n" +
                        "    select productId, img_url\n" +
                        "    from product_images\n" +
                        "    limit 1\n" +
                        "  ) as images on products.id = images.productId\n" +
                        "\n" +
                        "  join (\n" +
                        "    select order_products_details.productId\n" +
                        "    from orders_products_details join orders\n" +
                        "      on orders_products_details.orderId = orders.id\n" +
                        "    where \n" +
                        "      orders.createdAt >= now() - interval 3 month\n" +
                        "      and order_products_details.productId in (\n" +
                        "        select productId \n" +
                        "        from order_products_details\n" +
                        "        group by productId \n" +
                        "        order by count(productId)\n" +
                        "        limit 5\n" +
                        "    ) as limit_orders on limit_orders.productId = products.id\n" +
                        "limit 5\n").mapToBean(Object.class).list()
        );
    }

    //Tạm
    public List<Object> getMostRatedProducts() {
        return JDBIConnector.getInstance().withHandle(handle ->
            handle.createQuery("").mapToBean(Object.class).list()
        );
    }
}