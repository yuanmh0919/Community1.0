package com.yuanmh.service;

import com.yuanmh.dao.DiscussPostMapper;
import com.yuanmh.entity.DiscussPost;
import com.yuanmh.utils.Constant;
import com.yuanmh.vo.Result;

import java.util.List;

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

        result.setData(discussPosts);
        return result;
    }
}
