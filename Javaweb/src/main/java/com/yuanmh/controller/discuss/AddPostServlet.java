package com.yuanmh.controller.discuss;

import com.alibaba.fastjson.JSON;
import com.yuanmh.entity.DiscussPost;
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
 * @Date: 上午11:38 2024/7/11
 * @Describe:
 */

@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {
    private DiscussPostService discussPostService = new DiscussPostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String userId = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        DiscussPost discussPost = new DiscussPost(userId, title, content);
        Result result = null;
        try {
            result = discussPostService.addDiscussPost(discussPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(JSON.toJSONString(result));
    }
}
