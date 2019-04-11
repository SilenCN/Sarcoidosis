package cn.silen_dev.sarcoidosis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.silen_dev.sarcoidosis.dao")
public class SarcoidosisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SarcoidosisApplication.class, args);
    }
}
