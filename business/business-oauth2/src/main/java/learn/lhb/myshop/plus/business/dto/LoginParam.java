package learn.lhb.myshop.plus.business.dto;

import java.io.Serializable;

/**
 * 登录参数
 * 前端传递的
 *
 * @author 梁鸿斌
 * @date 2020/3/7.
 * @time 15:58
 */
public class LoginParam implements Serializable {
    private static final long serialVersionUID = -8609766857686302697L;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
