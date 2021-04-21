package cn.hoscen.demo.hscms.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTimeOutController {

    @Autowired
    private Environment env;

    /**
     * 故意让此方法调用时间过长，导致调用超时
     * @return
     */
    @GetMapping("/timeout/hello")
    public String getHelloMsg(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello, this is timeout  eureka-client:" +this.env.getProperty("server.port");
    }

}
