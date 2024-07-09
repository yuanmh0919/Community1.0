package com.yuanmh.controller.login;

import com.alibaba.fastjson.JSON;
import com.yuanmh.entity.User;
import com.yuanmh.service.UserService;
import com.yuanmh.utils.Constant;
import com.yuanmh.utils.MD5Util;
import com.yuanmh.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午5:52 2024/7/9
 * @Describe:
 */


@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Constant {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //先判断验证码
        String code = req.getParameter("captcha");
        if (code == null || "".equalsIgnoreCase(code)) {
            Result result = new Result(CAPTCHA_IS_EMPTY, "验证码不能为空");
            resp.getWriter().write(JSON.toJSONString(result));
            return;
        } else if (!code.equals(req.getSession().getAttribute("captcha"))) {
            Result result = new Result(CAPTCHA_ERROR, "验证码错误");
            resp.getWriter().write(JSON.toJSONString(result));
            return;
        }
        //验证码正确，开始判断用户名和密码是否正确
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Result result = new Result();
        //根据用户名查找用户
        try {
            result = userService.findUserByUsername(username);
            User user = (User) result.getData();
            //配对密码是否正确
            String md5Password = MD5Util.getMD5String(password + user.getSalt());
            if (md5Password.equals(user.getPassword())) {
                //登录成功
                result.setCode(SUCCESS);
            } else {
                result.setCode(USERNAME_OR_PASSWORD_ERROR);
                result.setMessage("密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(JSON.toJSONString(result));
    }
}
