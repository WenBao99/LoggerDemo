package com.wenbao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenbao.bean.User;
import com.wenbao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void insert() {
        User user = new User();
        user.setName("test2");
        user.setAge(22);
        user.setEmail("wenbao1102@icloud.com");

        System.out.println(userMapper.insert(user));
    }

    @Test
    void updateById() {
        User user = new User();
        user.setName("test223");
        user.setId(11);
        user.setAge(22);
        user.setEmail("wenbao1102@icloud.com");
        System.out.println(userMapper.updateById(user));
    }


    @Test
        //测试乐观锁 单线程
    void testOptimisticLocker() {
        //查询用户信息
        User user = userMapper.selectById(3);
        //修改用户信息
        user.setName("test2");
        int i = userMapper.updateById(user);
    }

    @Test
        //测试乐观锁 多线程
    void testOptimisticLocker2() {
        //线程A
        User user = userMapper.selectById(11);
        user.setName("test111");

        //线程B
        User user2 = userMapper.selectById(11);
        user2.setName("test222");

        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    @Test //同时查询多个用户
    void testFindByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.err::println);

    }

    @Test //条件查询
    void testFindByBatch(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","test222");
        List<User> users = userMapper.selectByMap(objectObjectHashMap);
        users.forEach(System.err::println);
    }

    @Test //分页查询
    void testFindByLimit(){
        /**
         * current:当前页
         * size:页面大小
         */
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.err::println);
    }

    @Test //逻辑删除
    void testDeletedById(){
        System.out.println(userMapper.deleteById(1L));
    }

}
