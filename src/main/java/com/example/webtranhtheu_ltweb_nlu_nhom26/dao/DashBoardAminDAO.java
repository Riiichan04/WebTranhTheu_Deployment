package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface DashBoardAminDAO {
    @SqlQuery("select count(id) from categories")
    int countCategories();

    @SqlQuery("select count(id) from topics")
    int countTopics();

    @SqlQuery("select count(id) from products")
    int countProducts();

    @SqlQuery("select count(id) from policies")
    int countPolicies();

    @SqlQuery("select count(id) from accounts")
    int countAccounts();

    @SqlQuery("select count(id) from orders")
    int countOrders();

    @SqlQuery("select count(id) from orders where statusOrder = :statusOrder")
    int countOrdersStatus(@Bind("statusOrder") int statusOrder);

    @SqlQuery("select count(id) from orders where statusPay = :statusPay")
    int countPaymentStatus(@Bind("statusPay") int statusPay);

    @SqlQuery("select sum(price*amount) from order_products_details op join orders o on op.orderId = o.id where o.statusPay = 1")
    double sumOrderValue();

    @SqlQuery(
            "SELECT o.id, a.username, a.fullname AS name, " +
                    "SUM(op.price * op.amount) AS totalPrice, " +
                    "o.createdAt, o.statusOrder AS orderStatus, o.statusPay AS paymentStatus " +
                    "FROM orders o " +
                    "JOIN order_products_details op ON o.id = op.orderId " +
                    "JOIN accounts a ON o.accountId = a.id " +
                    "WHERE o.createdAt >= NOW() - INTERVAL 1 MONTH " +
                    "GROUP BY o.id, a.username, a.fullname, o.createdAt, o.statusOrder, o.statusPay"
    )
    @RegisterBeanMapper(OrderDTO.class)
    List<OrderDTO> getLastListOrder();


}
