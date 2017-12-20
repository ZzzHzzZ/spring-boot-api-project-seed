package com.company.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import java.util.Date;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 * @company: www.ideabinder.com
 */
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    @JsonProperty("nick_name")
    private String nickName;
    private Integer sex;
    @JsonProperty("register_date")
    private Date registerDate;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
