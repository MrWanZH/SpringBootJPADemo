package com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dao;

import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.GroupDO;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户服务数据接口类
 *
 * @Author wan
 * @Create 2019/7/23 11:02
 */
@Repository
public interface GroupDao extends JpaRepository<GroupDO, Long> {
    public GroupDO findByAccount(String account);
    public GroupDO findByAccountAndPwd(String account, String pwd);
}
