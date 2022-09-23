package com.example.dao;

import com.example.entity.Item;

import java.util.List;

public interface ItemDao {
    public boolean isExist(Item item);

    public List<Item> QueryAll();

    public List<Item> QueryItemByChild1(String child);

    public List<Item> QueryItemByChild3(String child);

    public List<Item> QueryItemByCode(String child);

    public Item QueryItemById(Item item);

    public int AddItem(Item item);

    public int UpdateItemById(Item item);

    public int DeleteItemById(int id);
}
