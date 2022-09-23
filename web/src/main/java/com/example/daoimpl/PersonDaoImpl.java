package com.example.daoimpl;

import com.example.dao.PersonDao;

import com.example.entity.Item;
import com.example.entity.Person;
import com.example.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {
    /*添加身份信息*/
    public int AddPerson(Person person) {
        String sql = "insert into person values(null,?,?,?,?,?)";
        Object params[] = {person.getIdcard(), person.getUsername(),person.getTitle(), person.getEducation(), person.getBirthday()};
        return DBUtils.executeUpdate(sql, params);
    }

    /*修改身份信息*/
    public int UpdatePerson(Person person) {
        String sql = "update person set username = ?,title = ?,education = ?,birthday = ? where idcard = ?";
        Object params[] = {person.getUsername(), person.getTitle(), person.getEducation(), person.getBirthday(), person.getIdcard()};
        return DBUtils.executeUpdate(sql, params);
    }

    /*查询身份信息*/
    public Person QueryPersonByIdcard(Person person) {
        Person Result = null;
        ResultSet rs = null;
        try {
            String sql = "select * from person where idcard = ?";
            Object params[] = {person.getIdcard()};
            rs = DBUtils.executeQuery(sql, params);
            if (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String idcard = rs.getString(2);
                String username = rs.getString(3);
                String title = rs.getString(4);
                String education = rs.getString(5);
                String birthday = rs.getString(6);
                Result = new Person(id, idcard, username, title, education, birthday);
            }
            return Result;
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
}
