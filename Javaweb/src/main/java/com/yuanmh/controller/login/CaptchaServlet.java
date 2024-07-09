package com.yuanmh.controller.login;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午5:51 2024/7/9
 * @Describe:
 */

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 验证码生成
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 4, 10);
        req.getSession().setAttribute("captcha", captcha.getCode());
        resp.setContentType("image/jpeg");
        captcha.write(resp.getOutputStream());
    }
}