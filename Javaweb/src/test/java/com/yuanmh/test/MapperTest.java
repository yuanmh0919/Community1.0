package com.yuanmh.test;

import com.yuanmh.dao.DiscussPostMapper;
import com.yuanmh.entity.DiscussPost;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Yuanmh
 * @Date: 上午10:57 2024/7/10
 * @Describe:
 */

public class MapperTest {

    private DiscussPostMapper discussPostMapper = new DiscussPostMapper();

    @Test
    public void testSearch() {
        try {
            List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPostByAuthorAndTitleAndStatus("yuanmh", null, 0, 0, 10);
            for (DiscussPost discussPost : discussPosts) {
                System.out.println(discussPost);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testSelectDiscussPostById() {
        try {
            DiscussPost discussPost = discussPostMapper.selectDiscussPostById(281);
            System.out.println(discussPost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testDeleteDiscussPostById() {
        try {
            int i = discussPostMapper.deleteDiscussPostById(290);
            System.out.println(i == 1 ? "删除成功" : "删除失败");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
