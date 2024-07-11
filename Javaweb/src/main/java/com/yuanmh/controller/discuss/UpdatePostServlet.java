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
 * @Date: 下午3:35 2024/7/11
 * @Describe:
 */
@WebServlet("/updatePost")
public class UpdatePostServlet extends HttpServlet {
    private DiscussPostService discussPostService = new DiscussPostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        int postId = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Result result = new Result();
        try {
            Result discussPostById = discussPostService.findDiscussPostById(postId);
            DiscussPost data = (DiscussPost) discussPostById.getData();
            data.setTitle(title);
            data.setContent(content);
            result = discussPostService.updateDiscussPost(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(JSON.toJSONString(result));
    }
}
