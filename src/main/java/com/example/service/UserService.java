package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-03 22:06
 */
public interface UserService {
    //用户验证登录
    User queryUser(String name);

    //添加一个用户
    public int addUser(User user);

    //修改账户
    public int updateUser(User user);

    //查询所有用户
    public List<User> queryAllUser();

    //删除一个用户
    public int deleteUser(int user_id);

    //根据用户id来查找user
    public User queryUserById(int user_id);


}
