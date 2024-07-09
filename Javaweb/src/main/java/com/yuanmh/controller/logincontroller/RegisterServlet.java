package com.yuanmh.controller.logincontroller;

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
import java.util.Random;
import java.util.UUID;

/**
 * @Author: Yuanmh
 * @Date: 下午6:34 2024/7/8
 * @Describe:
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet implements Constant {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //TODO 注册逻辑
        Result result = null;
        try {
            User user = new User();
            user.setUsername(username);
            String salt = UUID.randomUUID().toString().substring(0, 5).replaceAll("-", "");
            user.setSalt(salt);
            user.setPassword(MD5Util.getMD5String(password + salt));
            user.setEmail(email);
            user.setType(0);
            user.setStatus(0);
            user.setActivation_code(username + salt);
            user.setHeader_url("http://images.nowcoder.com/head/" + new Random().nextInt(1000) + "t.png");
            result = userService.addUser(user);
            result.setData(user);
            //返回前端页面
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
