package com.example.daoimpl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements UserDao {
   /*判断账号是否存在*/
   public boolean isExist(User user) {
       return QueryItemById(user) == null ? true : false;
   }
  /*登录时查询单个账号*/
  public User QueryItemById(User user) {
      User itemResult = null;
      ResultSet rs = null;
      try {
          String sql = "select * from user where iphone = ? and pwd = ?";
          Object params[] = {user.getIphone(),user.getPwd()};
          rs = DBUtils.executeQuery(sql, params);
          if (rs.next()) { //当只有一条记录时，使用if
              int id = rs.getInt(1);
              String iphone = rs.getString(2);
              String idcards = rs.getString(3);
              String pwd = rs.getString(4);
              itemResult = new User(id, iphone,idcards,pwd);
          }
          return itemResult;
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
          return null;
      } catch (SQLException e) {
          e.printStackTrace();
          return null;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      } finally {
          try {
              if (DBUtils.conn != null) DBUtils.conn.close();
              if (DBUtils.pstmt != null) DBUtils.pstmt.close();
              if (rs != null) rs.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
    /*注册时查询单个账号*/
    public User QueryUserByForGet(User user) {
        User itemResult = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where iphone = ? and idcards = ?";
            Object params[] = {user.getIphone(),user.getIdcards()};
            rs = DBUtils.executeQuery(sql, params);
            if (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String iphone = rs.getString(2);
                String idcards = rs.getString(3);
                String pwd = rs.getString(4);
                itemResult = new User(id, iphone,idcards,pwd);
            }
            return itemResult;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (DBUtils.conn != null) DBUtils.conn.close();
                if (DBUtils.pstmt != null) DBUtils.pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
  /*注册账号*/
  public int AddUser(User user) {
      String sql = "insert into user values(null,?,?,?)";
      Object params[] = {user.getIphone(),user.getIdcards(),user.getPwd()};
      return DBUtils.executeUpdate(sql, params);
  }
  /*修改密码*/
  public int UpdateUser(User user) {
        String sql = "update user set pwd = ? where iphone = ? and idcards = ?";
        Object params[] = {user.getPwd(),user.getIphone(),user.getIdcards()};
        return DBUtils.executeUpdate(sql, params);
  }
}
