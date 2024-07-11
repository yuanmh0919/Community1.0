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
 * @Date: 上午11:18 2024/7/11
 * @Describe:
 */

@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {
    private DiscussPostService discussPostService = new DiscussPostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Result result = null;
        try {
            result = discussPostService.deleteDiscussPostById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().print(JSON.toJSONString(result));

    }
}
