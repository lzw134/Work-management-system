package com.example.servlet.PersonServlet;

import com.example.entity.Person;
import com.example.entity.User;
import com.example.service.PersonService;
import com.example.service.UserService;
import com.example.serviceimpl.PersonServiceImpl;
import com.example.serviceimpl.UserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", value = "/person-select")
public class PersonSelect extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String idcard = request.getParameter("idcard");
        Person person = new Person(idcard);
        PersonService service = new PersonServiceImpl();
        Person result = service.selectPerson(person);
        JSONArray json = JSONArray.fromObject(result);
        out.println(json.toString());
        out.flush();
        out.close();
    }


    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
