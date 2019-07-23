package com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dao;

import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.RoleDO;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.RoleUserDO;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务数据接口类
 *
 * @Author wan
 * @Create 2019/7/23 11:02
 */
@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {
    public UserDO findByAccount(String account);
    public UserDO findByAccountAndPwd(String account, String pwd);
    public List<UserDO> findAllByIdGreaterThan(Long id);
    public List<UserDO> findAllByIdGreaterThanEqual(Long id);

    @Query("SELECT O FROM UserDO O WHERE O.name = :name1  OR O.name = :name2 ")
    List<UserDO> findTwoName(@Param("name1") String name1, @Param("name2") String name2);

    @Query(nativeQuery = true, value = "SELECT * FROM AUTH_USER WHERE name = :name1  OR name = :name2 ")
    List<UserDO> findSQL(@Param("name1") String name1, @Param("name2") String name2);

    @Query("SELECT U FROM UserDO U ,RoleUserDO RU WHERE U.id = RU.userId AND RU.roleId = :roleId")
    List<UserDO> findUsersByRole(@Param("roleId") Long roleId);

    @Query("SELECT U.ID, U.ACCOUNT, U.NAME, U.PWD FROM AUTH_USER U ,AUTH_ROLE_USER RU WHERE U.id = RU.user_id AND RU.role_id = :roleId")
    List<UserDO> findUsersByRole2(@Param("roleId") Long roleId);

    @Query("SELECT U.ID, U.ACCOUNT, U.NAME, U.PWD, RU.ROLE_ID FROM AUTH_USER U ,AUTH_ROLE_USER RU WHERE U.id = RU.user_id AND RU.role_id = :roleId")
    List<RoleUserDO> findUsersByRole3(@Param("roleId") Long roleId);
}
