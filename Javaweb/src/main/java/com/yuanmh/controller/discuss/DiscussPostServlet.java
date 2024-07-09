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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //查找所有帖子 并支持分页
        //分页参数
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        currentPage = (currentPage - 1) * pageSize;
        //分页查询
        Result result = new Result();
        try {
            result = discussPostService.findAllDiscussPosts(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回json数据
        resp.getWriter().write(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd"));
    }
}
