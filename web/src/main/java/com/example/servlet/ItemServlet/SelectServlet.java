package com.example.servlet.ItemServlet;

import com.example.entity.Item;
import com.example.service.ItemService;
import com.example.serviceimpl.ItemServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SelectServlet", value = "/select-servlet")
public class SelectServlet extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        /*接收需要查询的类型*/
        String type =request.getParameter("type");
        String child =request.getParameter("child");
        PrintWriter out = response.getWriter();
        ItemService itemservice = new ItemServiceImpl();
        ArrayList<Item> items = null;
        if(type.equals("all")){
            items  =  (ArrayList<Item>)itemservice.queryallitem();
        }else if(type.equals("child1")){
            items  =  (ArrayList<Item>)itemservice.queryallitembychild1(child);
        }else if(type.equals("child3")){
            items  =  (ArrayList<Item>)itemservice.queryallitembychild3(child);
        }
        JSONArray json = JSONArray.fromObject(items);
        out.println(json.toString());
        out.flush();
        out.close();

    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
