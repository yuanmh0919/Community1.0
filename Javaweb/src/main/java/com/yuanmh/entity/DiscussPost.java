package com.yuanmh.entity;

import java.util.Date;

/**
 * @Author: Yuanmh
 * @Date: 下午7:23 2024/7/9
 * @Describe:
 */

public class DiscussPost {
    private Integer id;
    private String user_id;
    private String title;
    private String content;
    private Integer type;
    private Integer status;
    private Date create_time;
    private Integer comment_count;
    private Double score;
    //帖子作者
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DiscussPost() {
    }

    public DiscussPost(String user_id, String title, String content) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

    public DiscussPost(String user_id, String title, String content, Integer type, Integer status, Date create_time, Integer comment_count, Double score) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.status = status;
        this.create_time = create_time;
        this.comment_count = comment_count;
        this.score = score;
    }

    public DiscussPost(String user_id, String title, String content, Integer type, Integer status, Date create_time, Integer comment_count, Double score, String username) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.status = status;
        this.create_time = create_time;
        this.comment_count = comment_count;
        this.score = score;
        this.username = username;
    }

    @Override
    public String toString() {
        return "DiscussPost{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", create_time='" + create_time + '\'' +
                ", comment_count=" + comment_count +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
