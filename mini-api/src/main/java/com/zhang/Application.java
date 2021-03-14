package com.zhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author by SUNS3T
 * @Classname Application
 * @Description TODO
 */
@SpringBootApplication(scanBasePackages = {"com.zhang", "org.n3r.idworker"})
@MapperScan(basePackages = "com.zhang.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
