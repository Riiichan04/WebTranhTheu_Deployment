package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

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

    //    Cần add @Bind vào
    @SqlUpdate("""
            insert into orders(accountId, statusOrder, shippingAddress, statusPay, method) values (:accountId, :statusOrder, :shippingAddress, :statusPay, :method);
            """)
    @GetGeneratedKeys
    int createNewOrder(@Bind("accountId") int accountId, @Bind("statusOrder") int statusOrder, @Bind("shippingAddress") String shippingAddress, @Bind("statusPay") int statusPay, @Bind("method") int method);

    @SqlUpdate("""
            insert into order_products_details values(:orderId, :productId, :amount, :price, :width, :height)
            """)
    int addDetailToOrder(@Bind("orderId") int orderId, @Bind("productId") int productId, @Bind("amount") int amount, @Bind("price") double price, @Bind("width") int width, @Bind("height") int height);
}
