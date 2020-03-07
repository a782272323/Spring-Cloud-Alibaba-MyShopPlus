package learn.lhb.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 梁鸿斌
 * @date 2020/3/7.
 * @time 11:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessOAuth2Test {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void PasswordEncoderTest() {
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
