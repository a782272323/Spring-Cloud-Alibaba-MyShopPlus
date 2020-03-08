package learn.lhb.myshop.plus.business.controller;

import learn.lhb.myshop.plus.commons.dto.BaseResult;
import learn.lhb.myshop.plus.provider.api.UmsAdminService;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 14:30
 */
@RestController
@RequestMapping("profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @GetMapping(value = "info/{username}")
    public BaseResult info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.getUmsAdminByUsername(username);
        return BaseResult.ok().put(BaseResult.CodeStatus.OK, "查询用户信息成功", "data", umsAdmin);
    }
}
