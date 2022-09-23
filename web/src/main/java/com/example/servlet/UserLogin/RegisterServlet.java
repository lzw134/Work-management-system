package com.example.servlet.UserLogin;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.serviceimpl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String iphone = request.getParameter("iphone");
        String idcards = request.getParameter("idcard");
        String pwd = request.getParameter("pass");
        User user = new User(iphone,idcards,pwd);
        UserService service = new UserServiceImpl();
        int result = service.register(user);
        out.println(result);
        out.flush();
        out.close();
    }
    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
