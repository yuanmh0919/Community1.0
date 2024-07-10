package com.yuanmh.service;

import com.yuanmh.dao.DiscussPostMapper;
import com.yuanmh.entity.DiscussPost;
import com.yuanmh.utils.Constant;
import com.yuanmh.vo.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yuanmh
 * @Date: 下午7:31 2024/7/9
 * @Describe:
 */

public class DiscussPostService implements Constant {
    private DiscussPostMapper discussPostMapper = new DiscussPostMapper();

    private UserService userService = new UserService();

    //查找所有帖子并分页
    public Result findAllDiscussPosts(int offset, int limit) throws Exception {
        List<DiscussPost> discussPosts = discussPostMapper.selectAllDiscussPost(offset, limit);
        Result result = new Result();
        if (discussPosts == null || discussPosts.isEmpty()) {
            return new Result(NO_POST, "暂无帖子");
        }
        //将用户信息封装到map中 再填充到result.data中
        Map<String, Object> map = new HashMap<>();
        map.put("discussPosts", discussPosts);

        //添加查询总数
        int total = discussPostMapper.selectDiscussPostCount();
        map.put("total", total);
        //共有多少页
        int totalPage = (int) (Math.ceil((double) total / limit));
        map.put("totalCount", totalPage);
        result.setData(map);
        return result;
    }

    //搜索查询
    public Result searchDiscussPosts(String username, String title, Integer status, int offset, int limit) throws Exception {
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPostByAuthorAndTitleAndStatus(username, title, status, offset, limit);
        if (discussPosts == null || discussPosts.isEmpty()) {
            return new Result(NO_POST, "暂无帖子");
        }
        Result result = new Result();
        Map<String, Object> map = new HashMap<>();
        map.put("discussPosts", discussPosts);
        //查询总数
        int total = discussPostMapper.selectDiscussPostCount(username, title, status);
        map.put("total", total);
        int totalPage = (int) (Math.ceil((double) total / limit));
        map.put("totalCount", totalPage);
        result.setData(map);
        return result;
    }


}
