package com.fdh.demo3.consumer;

import com.fdh.dubbo3.service.DemoService;
import com.fdh.dubbo3.service.GreeterService;
import com.fdh.dubbo3.service.HelloReply;
import com.fdh.dubbo3.service.HelloRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Service
@EnableDubbo
public class Demo3ConsumerApplication {

    @DubboReference
    private GreeterService greeterService;

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(Demo3ConsumerApplication.class, args);
        Demo3ConsumerApplication application = context.getBean(Demo3ConsumerApplication.class);
        String result = application.doSayHello();
        System.out.println("*************result: " + result);
        new CountDownLatch(1).await();
    }

    public String doSayHello() {
        HelloReply helloReply = greeterService.sayHello(HelloRequest.newBuilder()
                .setName("triple9999")
                .build());
        return helloReply.getMessage();
    }

}
