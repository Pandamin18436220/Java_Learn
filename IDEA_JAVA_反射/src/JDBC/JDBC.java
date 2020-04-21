package JDBC;

/**
 * JDBC是java开发者使用数据库提供了统一的编程接口，它由一组java类和接口组成。是java程序与数据库系统通信的标准API.
 * JDBC API使得开发人员可以使用纯java的方式来连接数据库，并执行操作
 *
 * 访问数据库的流程
 *   - 加载驱动类
 *      - 装载驱动
 *           - MySql驱动
 *               - Class.forName("com.mysql.jdbc.Driver");
 *           - Oracle驱动
 *               - Class.forName("oracle.jdbc.driver.OracleDriver");
 *   - 连接数据库
 *          - DriverManager接口
 *              - DriverManager是JDBC的管理层，作用于用户和驱动程序之间
 *              - DriverManager跟踪可用的驱动程序，并在数据库和相应的驱动程序之间建立连接。
 *
 *          - Connection接口
 *              - DriverManager的getConnection()方法建立在JDBC URL中定义的数据库Connection连接上
 *              - 连接MySql数据库
 *                   - Connection con = DriverManager.getConnection("jdbc:mysql://host:port/database","user","password");
 *              - 连接ORACLE数据库
 *                   - Connection con = DriverManager.getConnection("jdbc:oracle:thin:@host:port:database","user","password");
 *   - SQL语句
 *   - 结果集
 */
public class JDBC {
}
