package com.wh.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(order = 10)
public class MySqlClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySqlClusterApplication.class, args);
    }

}
