package com.zhan.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zhan.service.server.MallMicroService;
import com.zhan.service.server.MyCommon;

/**
 * @author zhanzhan
 * @date 2021/7/30 20:44
 */
@SpringBootApplication
public class SpringBootStartMicroService {
    public static void main(String[] args) {
        // 采用自定义项目启动类的方式
        MallMicroService app = new MallMicroService();
        app.start(args);

        MyCommon.test();
    }
}
