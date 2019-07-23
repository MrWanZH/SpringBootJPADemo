package com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体类
 *
 * @Author wan
 * @Create 2019/7/23 14:21
 */
@Entity
@Table(name = "AUTH_ROLE")
public class RoleDO {
    @Id
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
