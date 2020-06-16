package com.zei.boot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 09:04
 */
@SpringBootApplication
@MapperScan({"com.zei.boot.demo.**.dao"})
public class ZeiBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeiBootApplication.class, args);
    }
}
