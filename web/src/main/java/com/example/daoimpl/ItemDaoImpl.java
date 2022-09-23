package com.example.daoimpl;

import com.example.dao.ItemDao;
import com.example.entity.Item;
import com.example.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    /*Dao层判断一个对象是否存在函数*/
    public boolean isExist(Item item) {
        return QueryItemById(item) == null ? true : false;
    }

    /*Dao层查询全部数据函数*/
    public List<Item> QueryAll() {
        List<Item> items = new ArrayList<Item>();
        Item item = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item";
            Object params[] = null;
            rs = DBUtils.executeQuery(sql, params);
            while (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String child1 = rs.getString(2);
                String child2 = rs.getString(3);
                String child3 = rs.getString(4);
                String child4 = rs.getString(5);
                String child5 = rs.getString(6);
                item = new Item(id, child1, child2, child3, child4, child5);
                items.add(item);
            }
            return items;
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

    /*Dao层根据child1查询*/
    public List<Item> QueryItemByChild1(String child) {
        List<Item> items = new ArrayList<Item>();
        Item item = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item where child1 = ?";
            Object params[] = {child};
            rs = DBUtils.executeQuery(sql, params);
            while (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String child1 = rs.getString(2);
                String child2 = rs.getString(3);
                String child3 = rs.getString(4);
                String child4 = rs.getString(5);
                String child5 = rs.getString(6);
                item = new Item(id, child1, child2, child3, child4, child5);
                items.add(item);
            }
            return items;
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

    /*Dao层根据child3查询*/
    public List<Item> QueryItemByChild3(String child) {
        List<Item> items = new ArrayList<Item>();
        Item item = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item where child3 = ?";
            Object params[] = {child};
            rs = DBUtils.executeQuery(sql, params);
            while (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String child1 = rs.getString(2);
                String child2 = rs.getString(3);
                String child3 = rs.getString(4);
                String child4 = rs.getString(5);
                String child5 = rs.getString(6);
                item = new Item(id, child1, child2, child3, child4, child5);
                items.add(item);
            }
            return items;
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

    /*Dao层根据模糊查询*/
    public List<Item> QueryItemByCode(String child) {
        List<Item> items = new ArrayList<Item>();
        Item item = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item where child1 like ? or child3 like ?";
            Object params[] = {"%"+child+"%","%"+child+"%"};
            rs = DBUtils.executeQuery(sql, params);
            while (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String child1 = rs.getString(2);
                String child2 = rs.getString(3);
                String child3 = rs.getString(4);
                String child4 = rs.getString(5);
                String child5 = rs.getString(6);
                item = new Item(id, child1, child2, child3, child4, child5);
                items.add(item);
            }
            return items;
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

    /*Dao层查询单个数据*/
    public Item QueryItemById(Item item) {
        Item itemResult = null;
        ResultSet rs = null;
        try {
            String sql = "select * from item where id = ?";
            Object params[] = {item.getId()};
            rs = DBUtils.executeQuery(sql, params);
            if (rs.next()) { //当只有一条记录时，使用if
                int id = rs.getInt(1);
                String child1 = rs.getString(2);
                String child2 = rs.getString(3);
                String child3 = rs.getString(4);
                String child4 = rs.getString(5);
                String child5 = rs.getString(6);
                itemResult = new Item(id, child1, child2, child3, child4, child5);
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

    /*Dao层增加数据函数*/
    public int AddItem(Item item) {
        String sql = "insert into item values(null,?,?,?,?,?)";
        Object params[] = {item.getChild1(), item.getChild2(), item.getChild3(), item.getChild4(), item.getChild5()};
        return DBUtils.executeUpdate(sql, params);
    }

    /*Dao层修改数据函数*/
    public int UpdateItemById(Item item) {
        String sql = "update item set child1=?,child2=?,child3=?,child4=?,child5=? where id = ?";
        Object params[] = {item.getChild1(), item.getChild2(), item.getChild3(), item.getChild4(), item.getChild5(), item.getId()};
        return DBUtils.executeUpdate(sql, params);
    }

    /*Dao层删除数据函数*/
    public int DeleteItemById(int id) {
        String sql = "delete from  item where id = ?";
        Object params[] = {id};
        return DBUtils.executeUpdate(sql, params);
    }
}
