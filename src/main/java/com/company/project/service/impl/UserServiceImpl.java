package com.company.project.service.impl;

import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 * @company: www.ideabinder.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void insertUser(User user) {
        user.setAdmin(false);
        user.setCtime(new Date());
        this.userMapper.insertSelective(user);
    }
}
