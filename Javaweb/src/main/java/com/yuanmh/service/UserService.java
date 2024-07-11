package com.yuanmh.service;

import com.yuanmh.dao.UserMapper;
import com.yuanmh.entity.User;
import com.yuanmh.utils.Constant;
import com.yuanmh.vo.Result;

/**
 * @Author: Yuanmh
 * @Date: 下午12:56 2024/7/9
 * @Describe:
 */

public class UserService implements Constant {
    private UserMapper userMapper = new UserMapper();

    /**
     * 注册用户
     *
     * @param user 用户对象
     * @return 注册结果
     */
    public Result addUser(User user) throws Exception {
        Result result = new Result();
        int i = userMapper.insertUser(user);
        if (i == 0) {
            return new Result(REGISTER_FAILED, "注册失败");
        }
        return result;
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    public Result findUserByUsername(String username) throws Exception {
        User user = userMapper.selectUserByUsername(username);
        if (user != null) {
            Result result = new Result(USER_ALREADY_EXIST, "用户已存在");//-4
            result.setData(user);
            return result;
        } else {
            return new Result();
        }
    }

    /**
     * 根据用户id查询用户
     *
     * @param id 用户id
     * @return result
     */
    public Result findUserById(int id) throws Exception {
        User user = userMapper.selectUserById(id);
        if (user != null) {
            Result result = new Result();//200
            result.setData(user);
            return result;
        } else {
            return new Result(USER_NOT_EXIST, "用户不存在");//-3
        }
    }

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return 更新结果
     */
    public Result updateUser(User user) throws Exception {
        Result result = new Result();
        int i = userMapper.updateUser(user);
        if (i == 1) {
            result.setData(user);
            return result;
        }
        return new Result(UPDATE_FAILED, "更新失败");
    }

}
