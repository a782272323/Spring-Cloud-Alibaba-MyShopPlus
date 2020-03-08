package learn.lhb.myshop.plus.business.dto;

import java.io.Serializable;

/**
 * 登录信息
 *
 * @author 梁鸿斌
 * @date 2020/3/8.
 * @time 11:21
 */
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = -4789580631177744005L;
    private String name;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
