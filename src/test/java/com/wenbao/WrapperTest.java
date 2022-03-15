package com.wenbao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenbao.bean.User;
import com.wenbao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wenbao
 * @data 2022/2/22
 * @Tip
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {
        //查询name、email不为空、年龄大于20的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 20);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.err::println);
    }

    @Test
    public void test2() {
        //查询name为jack的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .eq("name", "jack");
        User user = userMapper.selectOne(wrapper);
        System.err.println(user);
    }

    @Test
    public void test3() {
        //查询age在15-21之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 15, 21);
        System.err.println(userMapper.selectCount(wrapper));
    }

    @Test
    public void test4() {
        //模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name", "j")
                .likeRight("email", "t");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.err::println);
    }

    @Test
    public void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name", "t")
                .ge("age", 20);
        IPage<User> Page = userMapper.selectPage(new Page<>(1, 5), wrapper);
        Page.getRecords().forEach(System.out::println);

    }

    @Test
    public void test6() {
        User user = new User();
        user.setName("1111");
        user.setAge(22);
        user.setEmail("111@qq.com");
        userMapper.updateById(user);
    }


}
