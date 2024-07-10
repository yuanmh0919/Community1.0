package com.yuanmh.dao;

import com.yuanmh.entity.DiscussPost;
import com.yuanmh.utils.BaseMapper;

import java.util.ArrayList;
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
        String sql = "select post.*, user.username from discuss_post post " +
                "left join user on post.user_id = user.id " +
                "order by post.id desc limit ?,?";
        return baseMapper.queryMany(sql, DiscussPost.class, offset, limit);
    }

    /**
     * 查找帖子总数
     */
    public int selectDiscussPostCount() throws Exception {
        String sql = "select * from discuss_post";
        List<DiscussPost> discussPosts = baseMapper.queryMany(sql, DiscussPost.class);
        return discussPosts.size();
    }

    /**
     * 根据作者 标题 状态 动态查询帖子
     * <p>
     */
    public List<DiscussPost> selectDiscussPostByAuthorAndTitleAndStatus(String author, String title, Integer status, int offset, int limit) throws Exception {
        StringBuilder sql = new StringBuilder("select discuss.* " +
                "from (select post.*, user.username " +
                "from discuss_post post " +
                "left join user on post.user_id = user.id) " +
                "as discuss where 1=1 ");
        List<Object> param = new ArrayList<>();
        if (author != null && !author.trim().isEmpty()) {
            sql.append(" and discuss.username like ? ");
            param.add("%" + author.trim() + "%");
        }
        if (title != null && !title.trim().isEmpty()) {
            sql.append(" and discuss.title like ? ");
            param.add("%" + title.trim() + "%");
        }
        if (status != null) {
            sql.append(" and discuss.status = ? ");
            param.add(status);
        }
        sql.append(" order by discuss.id desc limit ?,? ");
        param.add(offset);
        param.add(limit);
        System.out.println(sql.toString());
        return baseMapper.queryMany(sql.toString(), DiscussPost.class, param.toArray());
    }

    /**
     * 查询总数
     */
    public int selectDiscussPostCount(String author, String title, Integer status) throws Exception {
        StringBuilder sql = new StringBuilder("select discuss.* " +
                "from (select post.*, user.username " +
                "from discuss_post post " +
                "left join user on post.user_id = user.id) " +
                "as discuss where 1=1 ");
        List<Object> param = new ArrayList<>();
        if (author != null && !author.trim().isEmpty()) {
            sql.append(" and discuss.username like ? ");
            param.add("%" + author.trim() + "%");
        }
        if (title != null && !title.trim().isEmpty()) {
            sql.append(" and discuss.title like ? ");
            param.add("%" + title.trim() + "%");
        }
        if (status != null) {
            sql.append(" and discuss.status = ? ");
            param.add(status);
        }
        return baseMapper.queryMany(sql.toString(), DiscussPost.class, param.toArray()).size();

    }

}
