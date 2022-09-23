package com.example.servlet.AboutServlet;

import com.example.entity.About;
import com.example.service.AboutService;
import com.example.serviceimpl.AboutServiceImpl;
import net.sf.json.JSONArray;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AboutSelect", value = "/about-select")
public class AboutSelect extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        AboutService aboutservice = new AboutServiceImpl();
        About about = aboutservice.queryaboutbyid(id);
        JSONArray json = JSONArray.fromObject(about);
        out.println(json.toString());
        out.flush();
        out.close();
    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
