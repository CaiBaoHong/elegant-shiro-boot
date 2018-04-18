package com.abc.shiro.entity;

import java.io.Serializable;

/**
 * created by CaiBaoHong at 2018/4/17 14:55<br>
 */
public class RolePerm implements Serializable {

    private Long roleId;
    private Long permId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }
}
