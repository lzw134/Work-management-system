package com.example.servlet.UserLogin;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.serviceimpl.UserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ForgetServlet", value = "/forget")
public class ForgetServlet extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String iphone = request.getParameter("iphone");
        String idcard = request.getParameter("idcard");
        String pass = request.getParameter("pass");
        User user = new User(iphone,idcard,pass);
        UserService service = new UserServiceImpl();
        int result = service.forget(user);
        out.println(result);
        out.flush();
        out.close();
    }

    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
