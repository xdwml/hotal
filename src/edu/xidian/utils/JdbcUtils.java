package edu.xidian.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * 封装常用的操作
 
 
 */
public class JdbcUtils {
    //初始化连接池
    private static DataSource dateSource;
    static {
        dateSource=new ComboPooledDataSource();
    }
    public static DataSource getDateSource(){
        return dateSource;
    }
    /**
     * 创建DbUtils常用工具类对象
     */
    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dateSource);
    }
}
