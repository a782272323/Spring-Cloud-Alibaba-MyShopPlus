package learn.lhb.myshop.plus.provider.service;

import learn.lhb.myshop.plus.provider.api.UmsAdminService;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import learn.lhb.myshop.plus.provider.mapper.UmsAdminMapper;
import leran.lhb.ny.shop.plus.commons.utils.TimeUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * 用户管理服务
 *
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 22:17
 */
@Service(version = "1.0.0")
public class UmsServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    @Override
    public int insert(UmsAdmin umsAdmin) {
        // 初始化系统用户对象
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    /**
     * 获取用户
     * @param username 用户名
     * @return
     */
    @Override
    public String getUsername(String username) {

        return umsAdminMapper.getUsername(username);
    }

    @Override
    public UmsAdmin getUmsAdminByOne(UmsAdmin umsAdmin) {
        return  null;
    }

    /**
     * 初始化系统用户对象
     * @param umsAdmin
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        // 初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        // 初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        // 密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }


}