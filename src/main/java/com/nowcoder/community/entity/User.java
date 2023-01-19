package com.nowcoder.community.entity;

import java.util.Date;

public class User {

    /*
username用户名称

password用户密码

salt盐用来加密

email用户的邮箱

type用户的类型 0表示普通用户 1表示超级管理员 2表示版主

status 0表示未激活 1表示激活

activation_code激活码

header_url头像地址

create_time用户注册时间
    * */
    private int id; //用户id

    private String username; //名称

    private String password; //密码

    private String salt; //用来加密

    private String email; //用户邮箱

    private int type; //用户的类型 0表示普通用户 1表示超级管理员 2表示版主

    private int status; //0表示未激活 1表示激活

    private String activationCode; //激活码

    private String headerUrl; //头像地址

    private Date createTime; //用户注册时间

    public User() {
    }

    public User(int id, String username, String password, String salt, String email, int type, int status, String activationCode, String headerUrl, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.type = type;
        this.status = status;
        this.activationCode = activationCode;
        this.headerUrl = headerUrl;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                ", headerUrl='" + headerUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
