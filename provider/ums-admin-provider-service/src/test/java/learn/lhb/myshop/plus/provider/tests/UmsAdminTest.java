package learn.lhb.myshop.plus.provider.tests;

import learn.lhb.myshop.plus.provider.api.UmsAdminService;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import learn.lhb.myshop.plus.provider.mapper.UmsAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 22:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UmsAdminTest {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 测试系统用户表全部信息查询
     */
    @Test
    public void selectAllTest() {
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(umsAdmin -> {
            System.out.println(umsAdmin.getUsername());
        });
    }

    /**
     * 测试系统用户表插入
     */
    @Test
    public void insertTest(){
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("test11");
        umsAdmin.setPassword(passwordEncoder.encode("123456"));
        umsAdmin.setEmail("123@124.com");
        umsAdmin.setIcon("http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/170157_yIl3_1767531.jpg");
        umsAdmin.setNickName("测试账号");
        umsAdmin.setStatus(1);
        if (umsAdminMapper.insert(umsAdmin) > 0) {
            System.out.println("插入数据成功！");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * 测试获取用户名
     */
    @Test
    public void getUsernameTest() {
        String username = "test1";
        System.out.println(umsAdminService.getUmsAdminByUsername(username).getUsername());
    }
}
