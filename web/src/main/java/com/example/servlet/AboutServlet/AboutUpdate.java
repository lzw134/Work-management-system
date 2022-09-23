package com.example.servlet.AboutServlet;

import com.example.entity.About;
import com.example.service.AboutService;
import com.example.serviceimpl.AboutServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AboutUpdate", value = "/about-update")
public class AboutUpdate extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String about = request.getParameter("about");
        About aboutItem = new About(id,about);
        AboutService aboutservice = new AboutServiceImpl();
        int result = aboutservice.updateabout(aboutItem);
        out.println(result);
        out.flush();
        out.close();
    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
