package testsql;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/14.
 */
public class TestSql {

    public static void main(String[] args) {
        //加载MySql的驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/student" ;
        String username = "root" ;
        String password = "root" ;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement("show create table book");
            rs = ps.executeQuery();
            //获取表名，不论getTableName()方法中索引为几，结果均为本表book
            //System.out.println("获取表名："+rs.getMetaData().getTableName(4));
            while (rs.next()) {
                System.out.println(rs.getString(rs.getMetaData().getColumnName(2)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
