package com.yuanmh.entity;

import java.util.Date;

/**
 * @Author: Yuanmh
 * @Date: 下午6:16 2024/7/8
 * @Describe:
 */

public class User {
    private Integer id;
    private String username;
    private String password;
    //密码盐
    private String salt;
    private String email;
    //用户类型：0-普通用户; 1-超级管理员; 2-版主;
    private Integer type;
    //用户状态：0-未激活; 1-已激活;
    private Integer status;
    //激活码
    private String activation_code;
    //头像
    private String header_url;
    //用户注册时间
    private Date create_time;

    public User() {
    }

    public User(String username, String password, String salt, String email, Integer type, Integer status, String activationCode, String headerUrl, Date createTime) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.type = type;
        this.status = status;
        this.activation_code = activationCode;
        this.header_url = headerUrl;
        this.create_time = createTime;
    }

    public User(Integer id, String username, String password, String salt, String email, Integer type, Integer status, String activationCode, String headerUrl, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.type = type;
        this.status = status;
        this.activation_code = activationCode;
        this.header_url = headerUrl;
        this.create_time = createTime;
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
                ", activationCode='" + activation_code + '\'' +
                ", headerUrl='" + header_url + '\'' +
                ", createTime=" + create_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public String getHeader_url() {
        return header_url;
    }

    public void setHeader_url(String header_url) {
        this.header_url = header_url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

}
