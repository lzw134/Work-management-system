package com.example.servlet.ItemServlet;

import com.example.entity.Item;
import com.example.service.ItemService;
import com.example.serviceimpl.ItemServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertServlet", value = "/insert-servlet")
public class InsertServlet extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String child1=request.getParameter("child1");
        String child2=request.getParameter("child2");
        String child3=request.getParameter("child3");
        String child4=request.getParameter("child4");
        String child5=request.getParameter("child5");
        Item item = new Item(child1,child2,child3,child4,child5);
        ItemService itemservice = new ItemServiceImpl();
        int result = itemservice.addItem(item);
        out.println(result);
        out.flush();
        out.close();
    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
