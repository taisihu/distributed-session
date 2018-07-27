package testoracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 */
public class TestOrclConnect {

    public static void main(String[] args) {
//        ResultSet rs = null;
//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            String dbURL = "jdbc:oracle:thin:@//192.168.0.236:1521/oap_prod";
//            conn = DriverManager.getConnection(dbURL, "oap_prod", "oap_prod");
//
//            String selectAllSql = "SELECT * FROM test_MW_ACCOUNT";
//
//            PreparedStatement ps = conn.prepareStatement(selectAllSql);
//
//            rs = ps.executeQuery();
//
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                    rs = null;
//                }
//                if (stmt != null) {
//                    stmt.close();
//                    stmt = null;
//                }
//                if (conn != null) {
//                    conn.close();
//                    conn = null;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }



        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:thin:@192.168.0.236:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "oap_prod";// 用户名,系统默认的账户名
            String password = "oap_prod";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            String sql = "SELECT * FROM test_MW_ACCOUNT where rownum<=2000";
            String sql1 = "select t.name,t.fgroupnum,t.mobile__c from test_mw_account t";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

            ResultSetMetaData rsmd = result.getMetaData() ;
            int columnCount = rsmd.getColumnCount();

            List<String> recordList = new ArrayList<String>();

            long startTime = System.currentTimeMillis();
            while (result.next()){
                String column_val_str = "";
                for(int i=1;i<=columnCount;i++){
                    column_val_str += ",";
                    column_val_str += result.getString(i);
                }
                recordList.add(column_val_str.substring(1));
            }
            long timedis = System.currentTimeMillis()-startTime;
            System.out.println("======获取记录时长:"+timedis);

            System.out.println("======记录总条数:"+recordList.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }
}