package learn.lhb.myshop.plus.business.service;

import com.google.common.collect.Lists;
import learn.lhb.myshop.plus.provider.api.UmsAdminService;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义认证授权
 *
 * @author 梁鸿斌
 * @date 2020/3/7.
 * @time 11:47
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

//    private static final String USERNAME = "admin";
//    private static final String PASSWORD = "$2a$10$m1vYO6oej.NpqYJyicSCL.nwVmLUfDJNReP/k/fPJiBhRibZkyJCq";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        // 授权
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);

        UmsAdmin umsAdmin = umsAdminService.getUmsAdminByUsername(username);
        // 账号存在
        if (umsAdmin != null) {
            return new User(umsAdmin.getUsername(),umsAdmin.getPassword(),grantedAuthorities);
        }
        // 账号不存在
        else {
            return null;
        }


        // 用户名匹配
//        if (username.equals(USERNAME)) {
//            // todo GrantedAuthority 做笔记到security
//            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//            // 授权
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
//            grantedAuthorities.add(grantedAuthority);
//            return new  User(USERNAME,PASSWORD,grantedAuthorities);
//        }
//        // 用户名不匹配
//        else {
//            return null;
//        }
    }
}
