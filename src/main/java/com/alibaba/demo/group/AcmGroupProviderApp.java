package com.alibaba.demo.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AcmGroupProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(AcmGroupProviderApp.class, args);
    }

}