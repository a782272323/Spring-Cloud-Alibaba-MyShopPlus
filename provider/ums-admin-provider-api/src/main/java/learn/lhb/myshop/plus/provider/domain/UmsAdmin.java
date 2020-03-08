package learn.lhb.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.util.Date;


/**
 * 系统用户表
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 21:58
 */
public class UmsAdmin implements Serializable {
    private static final long serialVersionUID = -6525470253150578208L;

    private Long id;
    private String username;
    private String password;
    /**
     * 头像
     */
    private String icon;
    /**
     * 邮件
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getLoginTime() {
//        return loginTime;
//    }
//
//    public void setLoginTime(Date loginTime) {
//        this.loginTime = loginTime;
//    }

    /**
     * 备注信息
     */
    private String note;
    /**
     * 创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
    private String createTime;
    /**
     * 登录时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date loginTime;
    /**
     * 账号启用状态，0禁用，1启用
     */
    private Integer status;
    private String loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
