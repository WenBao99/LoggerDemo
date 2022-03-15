package com.wenbao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenbao.bean.User;
import com.wenbao.mapper.UserMapper;
import com.wenbao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenbao
 * @data 2022/3/15
 * @Tip
 */
@Service
@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {return userMapper.selectList(null);}

    @Override
    public void addOrUpdateUser(User user) {
        saveOrUpdate(user);
    }

    @Override
    public void deleteById(Integer id) {
        deleteById(id);
    }
}
