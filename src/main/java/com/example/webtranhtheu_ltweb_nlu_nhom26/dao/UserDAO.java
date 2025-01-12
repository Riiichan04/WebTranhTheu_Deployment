package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.AuthDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;


public interface UserDAO {
    @SqlQuery("select username from accounts where id = :id")
    String getUsername(@Bind("id") int id);

    @SqlUpdate("INSERT INTO accounts (email, avatar_url, username, fullname, pass, phone, gender, description, statusAccount, createdAt, updatedAt, role) " +
            "VALUES (:email, :avatarUrl, :username, :fullName, :password, :phone, :gender, :description, :statusAccount, :createdAt, :updatedAt, :role)")
    boolean addUser(@BindBean User user);

    @SqlQuery("select username from accounts where username = :username")
    String getUsername(@Bind("username") String username);

    @SqlQuery("select email from accounts where email = :email")
    String getEmail(@Bind("email") String email);

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

    @SqlQuery("select pass from accounts where username = :username")
    String getPassword(@Bind("username") String username);

}
