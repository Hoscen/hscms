package cn.hoscen.demo.hscms.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("/hello")
    public String getHelloMsg(){
        return "hello, this is eureka-client:" +this.env.getProperty("server.port");
    }

}
