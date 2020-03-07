package learn.lhb.myshop.plus.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 01:08
 */
@SpringBootApplication
@MapperScan(basePackages = "learn.lhb.myshop.plus.provider.mapper")
public class UmsAdminProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class, args);
    }
}
