package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
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

    @SqlQuery("select id from accounts where username = :username")
    Integer getId(@Bind("username") String username);

    @SqlUpdate("Update accounts set statusAccount = :status where id = :id")
    boolean updateStatus(@Bind("id") int id, @Bind("status") int status);
}
