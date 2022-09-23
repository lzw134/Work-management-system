package com.example.daoimpl;


import com.example.dao.AboutDao;
import com.example.entity.About;
import com.example.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutDaoImpl implements AboutDao {
    /*判断是否存在*/
    public boolean isExist(int id) {
        return QueryAboutById(id) == null ? true : false;
    }

    /*Dao层查询单个数据*/
    public About QueryAboutById(int i) {
        About AboutResult = null;
        ResultSet rs = null;
        try {
            String sql = "select * from about where id = ?";
            Object params[] = {i};
            rs = DBUtils.executeQuery(sql, params);
            if (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String about = rs.getString(2);
                AboutResult = new About(id, about);
            }
            return AboutResult;
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

    /*Dao层增加数据函数*/
    public int AddAbout(About about) {
        String sql = "insert into about values(?,?)";
        Object params[] = {about.getId(),about.getAbout()};
        return DBUtils.executeUpdate(sql, params);
    }

    /*Dao层修改数据函数*/
    public int UpdateAbout(About about) {
        String sql = "update about set about = ? where id = ?";
        Object params[] = {about.getAbout(),about.getId()};
        return DBUtils.executeUpdate(sql, params);
    }
}
