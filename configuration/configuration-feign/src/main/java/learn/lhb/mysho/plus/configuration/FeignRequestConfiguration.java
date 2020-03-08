package learn.lhb.mysho.plus.configuration;

import feign.RequestInterceptor;
import learn.lhb.mysho.plus.interceptor.FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的Feign拦截器
 * Feign 全局配置
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 15:27
 */
@Configuration
public class FeignRequestConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
