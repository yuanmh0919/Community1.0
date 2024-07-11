package com.yuanmh.controller.user;

import com.alibaba.fastjson.JSON;
import com.yuanmh.entity.User;
import com.yuanmh.service.UserService;
import com.yuanmh.utils.Constant;
import com.yuanmh.utils.MD5Util;
import com.yuanmh.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午5:38 2024/7/10
 * @Describe:
 */
@MultipartConfig
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet implements Constant {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //获取用户名 密码 头像信息
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part imgUrl = req.getPart("img");
        Result result = null;
        try {
            //根据id查询用户
            result = userService.findUserById(id);
            //更新用户信息
            User user = (User) result.getData();
            user.setUsername(username);
            user.setPassword(MD5Util.getMD5String(password + user.getSalt()));
            if (imgUrl != null) {
                //获取文件名字
                String imgName = imgUrl.getSubmittedFileName();
                //文件名字加上时间戳或者UUID
                imgName = System.currentTimeMillis() + imgName;
                //上传文件到指定路径
                imgUrl.write(getServletContext().getRealPath("/static") + "/img/" + imgName);
                user.setHeader_url(getServletContext().getContextPath() + "/static/img/" + imgName);
            }
            result = userService.updateUser(user);
            //更新session
            req.getSession().setAttribute("user", user);
            //重定向到list.html
            resp.sendRedirect(req.getContextPath() + "/pages/list.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(JSON.toJSONString(result));
    }
}
