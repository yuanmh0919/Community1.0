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

}
