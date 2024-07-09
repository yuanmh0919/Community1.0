package com.yuanmh.dao;

import com.yuanmh.entity.DiscussPost;
import com.yuanmh.utils.BaseMapper;

import java.util.List;

/**
 * @Author: Yuanmh
 * @Date: 下午7:27 2024/7/9
 * @Describe:
 */

public class DiscussPostMapper {
    private BaseMapper baseMapper = new BaseMapper();

    //查找所有帖子 并分页
//    # 根据user_id 查出username
//select post.*, user.username
//from discuss_post post
//         left join user on post.user_id = user.id
//limit 10;
    public List<DiscussPost> selectAllDiscussPost(int offset, int limit) throws Exception {
        String sql = "select post.*, user.username from discuss_post post left join user on post.user_id = user.id limit ?,?";
        return baseMapper.queryMany(sql, DiscussPost.class, offset, limit);
    }
}
