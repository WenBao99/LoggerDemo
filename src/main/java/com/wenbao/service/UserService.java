package com.wenbao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wenbao.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenbao
 * @data 2022/2/22
 * @Tip
 */
@Service
public interface UserService extends IService<User> {

    List<User> findAll();

    void addOrUpdateUser(User user);

    void deleteById(Integer id);
}
