package com.yuanmh.controller.logincontroller;

import com.alibaba.fastjson.JSON;
import com.yuanmh.service.UserService;
import com.yuanmh.utils.Constant;
import com.yuanmh.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午4:06 2024/7/9
 * @Describe:
 */

@WebServlet("/checkUser")
public class CheckUserIsExists extends HttpServlet implements Constant {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        Result result = null;
        try {
            result = userService.findUserByUsername(username);
            if (result.getCode() == USER_ALREADY_EXIST) {
                resp.getWriter().write(JSON.toJSONString(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
