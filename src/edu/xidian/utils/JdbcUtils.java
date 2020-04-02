package edu.xidian.utils;
import javax.sql.DataSource;

/**
 * 封装常用的操作
 
 
 */
public class JdbcUtils {
    //初始化连接池
    private static DataSource dateSource;
    static {
        dateSource=new ComboPooledDateSource();
    }
}
