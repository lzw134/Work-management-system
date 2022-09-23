package com.example.serviceimpl;

import com.example.dao.ItemDao;
import com.example.daoimpl.ItemDaoImpl;
import com.example.entity.Item;
import com.example.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    /*引入Dao层接口实现类*/
    ItemDao itemdao = new ItemDaoImpl();

    /*Service层查询全部数据*/
    public List<Item> queryallitem() {
        return itemdao.QueryAll();
    }

    /*Service层根据child1查询全部数据*/
    public List<Item> queryallitembychild1(String child) {
        return itemdao.QueryItemByChild1(child);
    }

    /*Service层根据child3查询全部数据*/
    public List<Item> queryallitembychild3(String child) {
        return itemdao.QueryItemByChild3(child);
    }

    /*Service层根据模糊查询全部数据*/
    public List<Item> queryallitembycode(String child) {
        return itemdao.QueryItemByCode(child);
    }

    /*Service层插入数据*/
    public int addItem(Item item) {
        return itemdao.AddItem(item);
    }

    /*Service层修改数据*/
    public int UpdateItem(Item item) {
        if (!itemdao.isExist(item)) {
            return itemdao.UpdateItemById(item);
        } else {
            return 0;
        }
    }

    /*Service层删除数据*/
    public int DeleteItem(Item item) {
        if (!itemdao.isExist(item)) {
            return itemdao.DeleteItemById((int) item.getId());
        } else {
            return 0;
        }
    }

}
