package com.example.service;

import com.example.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> queryallitem();

    public List<Item> queryallitembychild1(String child);

    public List<Item> queryallitembychild3(String child);

    public List<Item> queryallitembycode(String child);

    public int addItem(Item item);

    public int UpdateItem(Item item);

    public int DeleteItem(Item item);
}
