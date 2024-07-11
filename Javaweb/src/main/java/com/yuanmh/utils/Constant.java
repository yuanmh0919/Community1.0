package com.yuanmh.utils;

/**
 * @Author: Yuanmh
 * @Date: 下午1:59 2024/7/9
 * @Describe:
 */
public interface Constant {
    /**
     * 成功
     */
    int SUCCESS = 200;

    /**
     * 验证码为空
     */
    int CAPTCHA_IS_EMPTY = -1;

    /**
     * 验证码错误
     */
    int CAPTCHA_ERROR = -6;


    /**
     * 用户名或者密码错误
     */
    int USERNAME_OR_PASSWORD_ERROR = -2;

    /**
     * 用户不存在
     */
    int USER_NOT_EXIST = -3;

    /**
     * 用户已经存在
     */
    int USER_ALREADY_EXIST = -4;

    /**
     * 注册失败
     */
    int REGISTER_FAILED = -5;

    /**
     * 暂无帖子
     */
    int NO_POST = 1;

    /**
     * 更新失败
     */
    int UPDATE_FAILED = -7;


    /**
     * 删除失败
     */
    int DELETE_FAILED = -8;

    /**
     * 添加失败
     */
    int ADD_FAILED = -9;

}
