package com.example.util;

import java.sql.*;

public class DBUtils {
    private static  String mysqlurl ="jdbc:mysql://localhost:3306/scientific";
    private static  String mysqlname = "root";
    private static  String mysqlpass = "123456";


    public  static   Connection conn = null;
    public  static   PreparedStatement pstmt= null;
    /**
     * 查询数据库的总条数
     * @throws SQLException
     *
     */
    public static int getTotalCount(String sql) {//select count(1) from student
        int count = -1;
        ResultSet rs = null;
        try {
            pstmt =  createprepareStatement(sql,null);
            rs  = pstmt.executeQuery();
            if(rs.next()) {
                count  = rs.getInt(1);
            }
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            return  -1;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return  -1;
        }
        catch(Exception e){
            e.printStackTrace();
            return  -1;
        }
        finally {
            CloseAll(rs, pstmt, conn);
        }
        return count;
    }
    /*
     * 查询每页显示的数据
     *
     */
    public static int  executeUpdate(String sql,Object params[]) {
        int count = 0;
        try {
            count = createprepareStatement(sql, params).executeUpdate();
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return -1;
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            try {
                if(conn!=null)conn.close();
                if(pstmt!=null)pstmt.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static  ResultSet executeQuery(String sql,Object params[]) throws ClassNotFoundException, SQLException{
        return createprepareStatement(sql, params).executeQuery();
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection(mysqlurl,mysqlname,mysqlpass);
    }
    public static PreparedStatement createprepareStatement(String sql,Object params[]) throws SQLException, ClassNotFoundException {
        pstmt =getConnection().prepareStatement(sql);
        if(params!=null){
            for(int i = 0;i<params.length;i++) {
                pstmt.setObject(i+1,params[i]);
            }
        }
        return pstmt;
    }
    public static void  CloseAll(ResultSet rs,PreparedStatement pstmt,Connection conn)  {
        if(rs!=null) {
            try {
                rs.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null) {
            try {
                pstmt.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
