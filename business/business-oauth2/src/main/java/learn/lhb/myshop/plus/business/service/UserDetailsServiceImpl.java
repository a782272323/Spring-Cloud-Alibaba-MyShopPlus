package learn.lhb.myshop.plus.business.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
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

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$m1vYO6oej.NpqYJyicSCL.nwVmLUfDJNReP/k/fPJiBhRibZkyJCq";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // todo GrantedAuthority 做笔记到security
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        return new  User(USERNAME,PASSWORD,grantedAuthorities);
    }
}
