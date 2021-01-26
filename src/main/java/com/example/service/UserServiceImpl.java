package com.example.service;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-03 22:08
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String name) {
        return userMapper.queryUser(name);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public int deleteUser(int user_id) {
        return userMapper.deleteUser(user_id);
    }

    @Override
    public User queryUserById(int user_id) {
        return userMapper.queryUserById(user_id);
    }

}
