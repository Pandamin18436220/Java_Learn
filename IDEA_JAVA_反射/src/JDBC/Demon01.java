package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 与数据库建立连接
 */
public class Demon01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接（l连接对象内部其实包含了Socket对象，是一个远程连接，比较耗时，这是Connection对象的一个要点）
            //真正的开发者，为了提高效率，都会使用连接池管理连接对象
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","");
            long end = System.currentTimeMillis();
            System.out.println(con);
            System.out.println("建立连接，耗时："+(end - start)+"ms毫秒");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
