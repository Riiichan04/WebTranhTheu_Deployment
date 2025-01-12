package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Verify;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface VerifyDAO {
    @SqlUpdate("insert into verify_accounts(accountId, verifycode, dateExpire) values(:accountId, :verifyCode, :dateExpire)")
    boolean insertVerifyAccount(@BindBean Verify verify);

    @SqlQuery("select accountId from verify_accounts where verifycode = :verifyCode and dateExpire > NOW()")
    Integer getVerifyCode(@Bind("verifyCode") int verifyCode);

    @SqlUpdate("delete from verify_accounts WHERE accountId = :accountId")
    void deleteVerifyAccount(@Bind("accountId") int accountId);
}
