package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Address;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.WishProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.UserDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.BaseWishProductMapper;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.AuthDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDAO {
    @SqlQuery("select username from accounts where id = :id")
    String getUsername(@Bind("id") int id);

    @SqlUpdate("INSERT INTO accounts (email, avatar_url, username, fullname, pass, phone, gender, description, statusAccount, createdAt, updatedAt, role) " +
            "VALUES (:email, :avatarUrl, :username, :fullName, :password, :phone, :gender, :description, :statusAccount, :createdAt, :updatedAt, :role)")
    boolean addUser(@BindBean User user);

    @SqlQuery("select id from accounts where email = :email")
    Integer getIdByEmail(@Bind("email") String email);

    @SqlQuery("select email from accounts where id = :id")
    String getEmail(@Bind("id") int id);

    @SqlQuery("select id from accounts where username = :username")
    Integer getId(@Bind("username") String username);

    @SqlQuery("select id from accounts where email = :email and username = :username and statusAccount = 2")
    Integer getIdByEmailAndUsername(@Bind("email") String email, @Bind("username") String username);

    @SqlUpdate("Update accounts set statusAccount = :status where id = :id")
    boolean updateStatus(@Bind("id") int id, @Bind("status") int status);

    @SqlUpdate("Update accounts set pass = :password where id = :id and statusAccount = 2")
    boolean updatePassword(@Bind("id") int id, @Bind("password") String password);

    @SqlQuery("select id, statusAccount, role from accounts where username = :username")
    @RegisterBeanMapper(AuthDTO.class)
    AuthDTO getAuth(@Bind("username") String username);

    @SqlQuery("select statusAccount from accounts where id = :id")
    Integer getStatusAccount(@Bind("id") int id);

    @SqlQuery("select pass from accounts where username = :username")
    String getPassword(@Bind("username") String username);


    @SqlQuery("select a.id, a.fullname as fullName, a.username, a.gender, x.numOrderBought, a.createdAt, a.statusAccount from accounts a LEFT JOIN (select accountId, count(id) as numOrderBought from orders GROUP BY accountId) x on a.id = x.accountId where a.role = 0")
    @RegisterBeanMapper(UserDTO.class)
    List<UserDTO> getUsersDTO();

    @SqlUpdate("insert into accounts(email, avatar_url, username, fullname, pass, phone, gender, description, statusAccount, createdAt, updatedAt, role) " +
            "values (:email, :avatarUrl, :username, :fullName, :password, :phone, :gender, :description, :statusAccount, :createdAt, :updatedAt, :role)")
    @RegisterBeanMapper(User.class)
    boolean insertUser(@BindBean User user);

    @SqlQuery("select id, avatar_url as avatarUrl, username, fullname as fullName, pass as password, email, phone, gender, description, statusAccount, createdAt, updatedAt from accounts where id = :accountId and role = 0")
    @RegisterBeanMapper(User.class)
    User getUser(@Bind("accountId") int accountId);

    @SqlQuery("SELECT a.id, a.location FROM account_addresses_details ad join addresses a on ad.addressId = a.id where ad.accountId = :accountId")
    @RegisterBeanMapper(Address.class)
    List<Address> getLocation(@Bind("accountId") int accountId);

    @SqlQuery("select p.id, p.codeProduct, p.title, w.createdAt from wishlist_products w join products p on w.productId = p.id where w.accountId = :accountId")
    @RegisterRowMapper(BaseWishProductMapper.class)
    List<WishProduct> getWishProducts(@Bind("accountId") int accountId);

    @SqlUpdate("UPDATE accounts\n" +
            "SET avatar_url = :avatarUrl, fullname = :fullName, pass = :password, email = :email, phone = :phone, gender = :gender, description = :description, statusAccount = :statusAccount, updatedAt = :updatedAt " +
            "where id = :id")
    @RegisterBeanMapper(User.class)
    boolean updateUser(@BindBean User user);

    @SqlUpdate("DELETE from account_addresses_details\n" +
            "WHERE accountId = :accountId and addressId = :addressId")
    boolean deleteUserAddress(@Bind("accountId") int accountId, @Bind("addressId") int addressId);

    @SqlUpdate("insert into addresses(location) values(:location)")
    boolean insertAddress(@Bind("location") String location);

    @SqlUpdate("INSERT INTO account_addresses_details(accountId, addressId, createdAt, updatedAt) values(:accountId, :addressId, NOW(), NOW())")
    boolean insertUserAddress(@Bind("accountId") int accountId, @Bind("addressId") int addressId);

    @SqlQuery("select id from addresses where location = :location limit 1")
    Integer getIdByLocation(@Bind("location") String location);

    @SqlUpdate("insert into wishlist_products(accountId, productId, createdAt) values(:accountId, :productId, NOW())")
    boolean insertWishProduct(@Bind("accountId") int accountId, @Bind("productId") int productId);

    @SqlUpdate("DELETE FROM wishlist_products where accountId = :accountId and productId = :productId")
    void deleteWishProduct(@Bind("accountId") int accountId, @Bind("productId") int productId);

}
