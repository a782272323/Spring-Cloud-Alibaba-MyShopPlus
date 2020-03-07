package learn.lhb.myshop.plus.business.controller;

import learn.lhb.myshop.plus.provider.api.UmsAdminService;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import leran.lhb.ny.shop.plus.commons.dto.BaseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户注册.
 *
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 23:26
 */
@RestController
@RequestMapping(value = "reg")
@CrossOrigin(origins = "*",maxAge = 3600)
public class RegController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    /**
     * 注册
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link BaseResult}
     */
    @PostMapping(value = "")
    public BaseResult reg(@RequestBody UmsAdmin umsAdmin) {
        String message = validateReg(umsAdmin);

        // 通过验证
        if (message == null) {
            int result = umsAdminService.insert(umsAdmin);
            String username = umsAdminService.getUsername(umsAdmin.getUsername());
            // 注册成功
            if (result > 0) {
                return BaseResult.ok().put("username",username,200,"请求成功!");
            }
        }
        // 注册失败或者用户名重复
        return BaseResult.error(message != null ? message : "用户注册失败");
    }

    /**
     * 注册信息验证
     * @param umsAdmin {@link UmsAdmin}
     * @return 验证结果
     */
    private String validateReg(UmsAdmin umsAdmin) {
        String username = umsAdminService.getUsername(umsAdmin.getUsername());
        if (username != null) {
            return "用户名已经存在，请重新输入";
        }

        return  null;
    }
}
