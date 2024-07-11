package com.yuanmh.dao;

import com.yuanmh.entity.User;
import com.yuanmh.utils.BaseMapper;

import java.util.List;

/**
 * @Author: Yuanmh
 * @Date: 下午12:41 2024/7/9
 * @Describe:
 */

public class UserMapper {
    private BaseMapper baseMapper = new BaseMapper();

    /**
     * 用户注册 添加用户
     *
     * @param user 插入的对象
     * @return 受影响的行数
     */
    public int insertUser(User user) throws Exception {
        String sql = "insert into user(username,password,salt,email,type,status,activation_code,header_url,create_time) " + "values(?,?,?,?,?,?,?,?,now())";
        return baseMapper.cudMethod(sql, user.getUsername(), user.getPassword(), user.getSalt(), user.getEmail(), user.getType(), user.getStatus(), user.getActivation_code(), user.getHeader_url());
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    public User selectUserByUsername(String username) throws Exception {
        String sql = "select * from user where username = ?";
        List<User> users = baseMapper.queryMany(sql, User.class, username);
        if (users == null || users.isEmpty()) {
            return null;
        } else {
            return users.getFirst();
        }
    }

    /**
     * 通过id获取用户信息
     *
     * @param id 用户id
     * @return 用户对象
     */
    public User selectUserById(int id) throws Exception {
        String sql = "select * from user where id = ?";
        List<User> users = baseMapper.queryMany(sql, User.class, id);
        return users.getFirst();
    }

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return 受影响的行数
     */
    public int updateUser(User user) throws Exception {
        String sql = "update user set username =?, password =?, header_url =? where id = ?";
        return baseMapper.cudMethod(sql, user.getUsername(), user.getPassword(), user.getHeader_url(), user.getId());
    }

}
