package com.example.webtranhtheu_ltweb_nlu_nhom26.db;

import org.jdbi.v3.core.Jdbi;

public class JDBIConnector {
    static Jdbi jdbi;

    private static Jdbi createJdbi() {
        if (jdbi == null) {
            jdbi = Jdbi.create(new DBProperties().getConnection());
        }
        return jdbi;
    }

    public static Jdbi getInstance() {
        if (jdbi == null) {
            jdbi = createJdbi();
        }
        return jdbi;
    }
}
