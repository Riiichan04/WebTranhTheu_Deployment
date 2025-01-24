package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO {
    @SqlQuery(
            "SELECT o.id, a.username, a.fullname AS name, " +
                    "SUM(op.price * op.amount) AS totalPrice, " +
                    "o.createdAt, o.statusOrder AS orderStatus, o.statusPay AS paymentStatus " +
                    "FROM orders o " +
                    "JOIN order_products_details op ON o.id = op.orderId " +
                    "JOIN accounts a ON o.accountId = a.id " +
                    "GROUP BY o.id, a.username, a.fullname, o.createdAt, o.statusOrder, o.statusPay"
    )
    @RegisterBeanMapper(OrderDTO.class)
    List<OrderDTO> getListOrderDTO();

    @SqlUpdate("insert into orders(accountId, statusOrder, createdAt, deliveredAt, shippingAddress, statusPay, method)\n" +
            "values(:userId, :statusOrder, NOW(), :deliveredAt, :shippingAddress, :statusPay, :method)")
    boolean insertOrder(@Bind("userId") int userId, @Bind("statusOrder") int statusOrder, @Bind("deliveredAt") Timestamp deliveredAt, @Bind("shippingAddress") String shippingAddress, @Bind("statusPay") int statusPay, @Bind("method") int method);

    @SqlUpdate("insert into order_products_details(orderId, productId, amount, price, width, height)\n" +
            "values(:orderId, :productId, :amount, :price, :width, :height)")
    boolean insertOrderProduct(@Bind("orderId") int orderId, @Bind("productId") int productId, @Bind("amount") int amount, @Bind("price") int price, @Bind("width") int width, @Bind("height") int height);
}
