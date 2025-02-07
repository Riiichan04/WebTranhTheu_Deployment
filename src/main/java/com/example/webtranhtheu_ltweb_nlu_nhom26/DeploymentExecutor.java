package com.example.webtranhtheu_ltweb_nlu_nhom26;

import org.eclipse.jetty.util.ssl.SslContextFactory.*;

public class DeploymentExecutor {
    public static void main(String[] args) {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        Server server = new Server();

    }
}
