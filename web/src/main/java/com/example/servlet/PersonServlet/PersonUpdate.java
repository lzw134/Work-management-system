package com.example.servlet.PersonServlet;

import com.example.entity.Person;
import com.example.service.PersonService;
import com.example.serviceimpl.PersonServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonUpdate", value = "/person-update")
public class PersonUpdate extends HttpServlet {
    /*doget方法*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String idcard = request.getParameter("idcard");
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String education = request.getParameter("education");
        String birthday = request.getParameter("birthday");
        Person person = new Person(idcard,username,title,education,birthday);
        PersonService service = new PersonServiceImpl();
        int result = service.updatePerson(person);
        out.println(result);
        out.flush();
        out.close();
    }


    /*dopost方法*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
