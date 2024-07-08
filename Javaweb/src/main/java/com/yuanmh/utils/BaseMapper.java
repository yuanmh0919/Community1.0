package com.yuanmh.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yuanmh
 * @Date: 上午9:44 2024/7/8
 * @Describe: dao层util
 */

public class BaseMapper {
    /**
     * 可以执行任意的增删改语句
     *
     * @param sql 增删改语句
     * @param params 给占位符赋值
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int cudMethod(String sql, Object... params) throws Exception {
        Connection conn = DruidPool.getConnection();
        //获取数据库语句的执行对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //给？赋值
        if (null != params && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        //执行sql语句
        int i = ps.executeUpdate();
        DruidPool.close(conn, ps, null);
        return i;
    }

    /**
     * 可以执行任意的查询语句
     *
     * @param sql 查询语句
     * @param params 给占位符赋值
     * @param <T> c 查询结果的类型
     * @return 查询结果
     * @throws Exception 异常
     */
    public <T> List<T> queryMany(String sql, Class<T> c, Object... params) throws Exception {
        //获取数据库连接对象
        Connection connection = DruidPool.getConnection();
        //获取数据库语句的执行对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //给？赋值
        if (null != params && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        //执行sql语句
        ResultSet rs = ps.executeQuery();
        //获取结果集的元数据信息
        ResultSetMetaData metaData = rs.getMetaData();
        //从元数据中获取列的数量
        int columnCount = metaData.getColumnCount();
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            //反射创建T对象
            T t = c.newInstance();
            for (int i = 0; i < columnCount; i++) {
                //每一列的列名
                String columnName = metaData.getColumnLabel(i + 1);
                //获取列明对应的值
                Object value = rs.getObject(columnName);

                //反射给T对象赋值
                Field field = c.getDeclaredField(columnName);
                field.setAccessible(true);
                //如果说 oracle中数据是整型-----默认转成bigdecimal(整数+小数)类型
                if (value instanceof BigDecimal) {
                    if ((value + "").contains(".")) {
                        value = Double.parseDouble(value + "");
                    } else {
                        value = Integer.parseInt(value + "");
                    }
                }

                if (null != value) {
                    field.set(t, value);
                }
            }
            list.add(t);
        }
        DruidPool.close(connection, ps, rs);
        return list;
    }
}
