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
}
