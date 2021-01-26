package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-03 21:58
 */
@Repository
@Mapper
public interface UserMapper {
    //查询所有用户
    List<User> queryAllUser();

    //根据名称找用户
    public User queryUser(String name);

    //添加用户
    public int addUser(User user);

    //修改用户信息
    public int updateUser(User user);

    //删除一个用户
    public int deleteUser(int user_id);

    //查找一个用户
    public User queryUserById(int user_id);

}
