package com.wan.springboot.springbootlearn;

import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dao.GroupDao;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dao.UserDao;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.GroupDO;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.RoleUserDO;
import com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.security.domain.dto.UserDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJPALearn {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;

    @Before
    public void before() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDO();
        userDO.setId(3L);
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO.setId(5L);
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }

    @Test
    public void testAdd() {
        UserDO userDO = new UserDO();
        userDO.setId(2L);
        userDO.setName("任我行");
        userDO.setAccount("renwox");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDO();
        userDO.setId(4L);
        userDO.setName("令狐冲");
        userDO.setAccount("linghuc");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }

    @Test
    public void testLocate() {
        Optional<UserDO> userDOOptional = userDao.findById(1L);
        if (userDOOptional.isPresent()) {
            UserDO userDO = userDOOptional.get();
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void findAll() {
        List<UserDO> list = userDao.findAll();
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByAccount() {
        UserDO userDO = userDao.findByAccount("wentian");
        if (userDO != null) {
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void testFindByAccountPwd() {
        UserDO userDO = userDao.findByAccountAndPwd("wentian", "123456");
        if (userDO != null) {
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void testFind() {
        GroupDO groupDO = groupDao.findByAccount("wentian");
        if (groupDO != null) {
            System.out.println("name = " + groupDO.getName());
            System.out.println("account = " + groupDO.getAccount());
        }
    }

    @Test
    public void findAllByIdGreaterThan() {
        List<UserDO> list = userDao.findAllByIdGreaterThan(2L);
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findAllByIdGreaterThanEqual() {
        List<UserDO> list = userDao.findAllByIdGreaterThanEqual(2L);
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findTwoName() {
        List<UserDO> list = userDao.findTwoName("风清扬", "令狐冲");
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findSQL() {
        List<UserDO> list = userDao.findSQL("风清扬", "令狐冲");
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findUsersByRole() {
        List<UserDO> list = userDao.findUsersByRole(2L);
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findUsersByRole2() {
        List<UserDO> list = userDao.findUsersByRole2(2L);
        for (UserDO u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void findUsersByRole3() {
        List<RoleUserDO> list = userDao.findUsersByRole3(2L);
        for (RoleUserDO ru : list) {
            System.out.println("role_id:" + ru.getRoleId());
            System.out.println("role_id:" + ru.getUserId());
        }
    }

//    @After
//    public void after() {
//        userDao.deleteById(1L);
//        userDao.deleteById(3L);
//        userDao.deleteById(5L);
//    }

}
