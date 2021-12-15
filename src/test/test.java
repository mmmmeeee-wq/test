import java.sql.*;

public class test {

    private String dbUrl="jdbc:sqlserver://localhost:1433; DatabaseName=student_management";//数据库连接地址
    private String dbUserName="sa"; //用户名
    private String dbPassword="zwq5231120"; //密码
    private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动名称

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    /**
     * 关闭数据库连接
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con)throws Exception{
        if(con!=null) {
            con.close();
        }
    }

    public static void main(String[] args) {
        test dbUtil=new test();
        try {
            Connection con = dbUtil.getCon();
            System.out.println("数据库连接成功");
            Statement stmt = con.createStatement();
            stmt.close();
            dbUtil.closeCon(con);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }

    public static ResultSet Query(String sql) throws SQLException {
        test dbUtil=new test();
        // TODO Auto-generated method stub
        Connection con;
        ResultSet rs = null;
        try {
            con = dbUtil.getCon();
            Statement stmt = con.createStatement();
            //查询
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库查询失败");
        }
        return rs;
    }

    public static void Update(String sql) {
        // TODO Auto-generated method stub
        test dbUtil=new test();
        // TODO Auto-generated method stub
        Connection con;
        ResultSet rs = null;
        try {
            con = dbUtil.getCon();
            Statement stmt = con.createStatement();
            //插入
            stmt.executeUpdate(sql);

            stmt.close();
            dbUtil.closeCon(con);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库更新失败");
        }
    }
}
