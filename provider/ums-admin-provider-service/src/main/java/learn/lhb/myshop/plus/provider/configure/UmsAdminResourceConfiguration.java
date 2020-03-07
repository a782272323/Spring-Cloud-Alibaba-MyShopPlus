package learn.lhb.myshop.plus.provider.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 资源服务器配置
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 23:18
 */
@Configuration
public class UmsAdminResourceConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
