package com.alibaba.demo.normal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class SampleController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${user.name:123}")
    String userName;

    @Value("${user.age:123}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return  "; Hello ACM Config ," + "Hello " + userName + " " + age ;
    }


    @GetMapping("/_ehc")
    public String _ehc(){

        return "200" ;
    }

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "ok";
    }

    @RequestMapping("/service/{str}")
    public List<ServiceInstance> getServices(@PathVariable("str") String str) {
        return discoveryClient.getInstances(str);
    }
}