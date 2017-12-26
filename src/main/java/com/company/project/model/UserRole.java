package com.company.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/26
 * @company: www.ideabinder.com
 */
@Table(name = "t_user_role")
public class UserRole {
    @Id
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("role_id")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
