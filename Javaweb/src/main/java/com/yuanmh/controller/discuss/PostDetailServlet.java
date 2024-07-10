package com.yuanmh.controller.discuss;

import com.alibaba.fastjson.JSON;
import com.yuanmh.service.DiscussPostService;
import com.yuanmh.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午1:33 2024/7/10
 * @Describe:
 */

@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
    private DiscussPostService discussPostService = new DiscussPostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 接收参数
        int id = Integer.parseInt(req.getParameter("id"));
        // 业务逻辑处理
        Result result = new Result();
        try {
            result = discussPostService.findDiscussPostById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 结果输出
        resp.getWriter().write(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss"));
    }
}
