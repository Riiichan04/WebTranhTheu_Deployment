package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.Order;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.OrderProduct;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
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
    @SqlQuery(
            "SELECT o.id," +
                    "SUM(op.price * op.amount) AS totalPrice, " +
                    "o.createdAt, o.statusOrder AS status, o.statusPay AS statusPay " +
                    "FROM orders o " +
                    "JOIN order_products_details op ON o.id = op.orderId "
                    + "where o.accountId = :accountId"+
                    " GROUP BY o.id,o.createdAt, o.statusOrder, o.statusPay")
    @RegisterBeanMapper(Order.class)
    List<Order> getListOrderByUser(@Bind("accountId") int accountId);

    @SqlQuery(
            "SELECT p.id,p.title,op.amount as quantity,op.width,op.height,op.price " +
                    "FROM products p " +
                    "JOIN order_products_details op ON p.id = op.productId "+
                    "where op.orderId= :orderId "
    )
    @RegisterBeanMapper(OrderProduct.class)
    List<OrderProduct> getListOrderProductByOrderId(@Bind("orderId") int orderId);

    @SqlQuery(
            "SELECT o.id," +
                    "SUM(op.price * op.amount) AS totalPrice, " +
                    "o.createdAt, o.statusOrder AS status, o.statusPay AS statusPay " +
                    "FROM orders o " +
                    "JOIN order_products_details op ON o.id = op.orderId "
                    + "where o.accountId = :accountId and o.statusOrder =:statusOrder "+
                    " GROUP BY o.id,o.createdAt, o.statusOrder, o.statusPay")
    @RegisterBeanMapper(Order.class)
    List<Order> getListOrderByUserAndStatus(@Bind("accountId") int accountId, @Bind("statusOrder") int statusOrder);

    @SqlQuery(
            "SELECT o.id," +
                    "SUM(op.price * op.amount) AS totalPrice, " +
                    "o.createdAt,o.deliveredAt,o.method,o.shippingAddress,o.statusOrder AS status, o.statusPay AS statusPay,co.reason AS cancelReason " +
                    "FROM orders o " +
                    "LEFT JOIN cancel_orders co on co.orderId=o.id "+
                    "JOIN order_products_details op ON o.id = op.orderId "
                    + "where o.accountId = :accountId and o.id =:orderId "+
                    " GROUP BY o.id,o.createdAt,o.deliveredAt,o.method,o.shippingAddress,o.statusOrder,o.statusPay,co.reason"
    )
    @RegisterBeanMapper(Order.class)
    Order getOrderById(@Bind("accountId") int accountId,@Bind("orderId") int orderId);

    @SqlUpdate(
            "UPDATE orders SET statusOrder = :statusOrder where id = :orderId "
    )
    boolean updateOrderStatus(@Bind("orderId") int orderId, @Bind("statusOrder") int statusOrder);

    @SqlUpdate(
        "INSERT INTO cancel_orders (orderId,reason) VALUES (:orderId, :cancelReason)"
    )
    boolean insertCancelOrder(@Bind("orderId") int orderId,@Bind("cancelReason") int cancelReason);

}
