package com.yuanmh.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author: Yuanmh
 * @Date: 上午11:36 2024/6/2
 * @Describe: Druid连接池工具类
 */

public class DruidPool {
    //配置数据源
    private static DataSource dataSource;

    private static final String DRUID_CONFIG = "druid.properties";

    //初始化连接池
    static {
        try {
            InputStream is = DruidPool.class.getClassLoader().getResourceAsStream(DRUID_CONFIG);
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //从连接池中获取连接
        return dataSource.getConnection();
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
