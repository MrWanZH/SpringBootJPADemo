package com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 角色用户关系实体类
 *
 * @Author wan
 * @Create 2019/7/23 14:31
 */
@Entity
@IdClass(RoleUserId.class)
@Table(name = "AUTH_ROLE_USER")
public class RoleUserDO  {
    @Id
    private Long roleId;
    @Id
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
