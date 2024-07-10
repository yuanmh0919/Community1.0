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
 * @Date: 下午7:25 2024/7/9
 * @Describe:
 */

@WebServlet("/postList")
public class DiscussPostServlet extends HttpServlet {
    private DiscussPostService discussPostService = new DiscussPostService();

    private static final int PAGE_SIZE = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求参数
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        Integer status = Integer.parseInt(req.getParameter("status"));
        if (status == -1) {
            status = null;
        }
        //查找所有帖子 并支持分页
        //分页参数
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        currentPage = (currentPage - 1) * PAGE_SIZE;
        //分页查询
        Result result = new Result();
        try {
            result = discussPostService.searchDiscussPosts(author, title, status, currentPage, PAGE_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回json数据
        resp.getWriter().write(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd"));
    }
}
