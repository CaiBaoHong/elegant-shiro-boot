package com.abc.shiro.entity;

import java.io.Serializable;

/**
 * created by CaiBaoHong at 2018/4/17 14:55<br>
 */
public class UserRole implements Serializable {

    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
