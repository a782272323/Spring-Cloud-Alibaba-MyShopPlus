package learn.lhb.myshop.plus.business.feign;

import learn.lhb.mysho.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 14:34
 */
@FeignClient(value = "business-profile",path = "profile",configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    /**
     * 查询个人用户信息接口
     * @param username
     * @return
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);
}
