package com.fdh.dubbo3.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"com.fdh.dubbo3.provider"})
public class Demo3ProviderApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Demo3ProviderApplication.class, args);
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}
