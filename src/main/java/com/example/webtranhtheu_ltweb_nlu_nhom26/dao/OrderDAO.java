package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.orderAdmin.Order;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.orderAdmin.OrderDetails;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.BaseOrderDetailMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
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

    @SqlQuery("SELECT o.id, o.statusOrder, o.createdAt, CASE WHEN o.deliveredAt = '0000-00-00 00:00:00' THEN NULL ELSE o.deliveredAt END AS deliveredAt, o.shippingAddress, o.statusPay, o.method, ifnull(c.reason, -1) as cancelReason FROM orders o LEFT JOIN cancel_orders c on o.id = c.orderId WHERE o.id = :orderId")
    @RegisterBeanMapper(Order.class)
    Order getOrderById(@Bind("orderId") int orderId);

    @SqlQuery("select a.id, a.email from orders o join accounts a on o.accountId = a.id where o.id = :orderId")
    @RegisterBeanMapper(User.class)
    User getUserByOrderId(@Bind("orderId") int orderId);

    @SqlQuery("select p.id as productId, p.codeProduct, p.title, o.amount, o.width, o.height, o.price from order_products_details o join products p on o.productId = p.id where o.orderId = :orderId")
    @RegisterRowMapper(BaseOrderDetailMapper.class)
    List<OrderDetails> getOrderDetailByOrderId(@Bind("orderId") int orderId);

    @SqlUpdate("update orders set statusOrder = :statusOrder, deliveredAt = :deliveredAt where id = :orderId")
    boolean updateOrderStatus(@Bind("orderId") int orderId, @Bind("statusOrder") int statusOrder, @Bind("deliveredAt")Timestamp deliveredAt);

    @SqlUpdate("delete from cancel_orders where orderId = :orderId")
    void deleteCancelReasonByOrderId(@Bind("orderId") int orderId);

    @SqlUpdate("insert into cancel_orders(orderId, reason) values(:orderId, :reason)")
    void insertCancelReasonOrder(@Bind("orderId") int orderId, @Bind("reason") int reason);
}
