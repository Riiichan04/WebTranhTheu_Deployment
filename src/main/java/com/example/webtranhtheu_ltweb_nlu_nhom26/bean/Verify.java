package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import java.sql.Timestamp;

public class Verify {
    private int id;
    private int accountId;
    private int verifyCode;
    private Timestamp dateExpire;

    public Verify() {
    }

    public Verify(int accountId, int verifyCode, Timestamp dateExpire) {
        this.accountId = accountId;
        this.verifyCode = verifyCode;
        this.dateExpire = dateExpire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setDateExpire(Timestamp dateExpire) {
        this.dateExpire = dateExpire;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public Timestamp getDateExpire() {
        return dateExpire;
    }
}
