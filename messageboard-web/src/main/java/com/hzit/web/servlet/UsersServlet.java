package com.hzit.web.servlet;



import com.hzit.dao.entity.Userinfo;
import com.hzit.web.services.UserServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13.
 */

public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        UserServiesImpl userServiesImpl=new UserServiesImpl();
        Userinfo userinfo=userServiesImpl.login(name,pwd);
        if (userinfo!=null){
            request.getSession().setAttribute("user",userinfo);
            response.sendRedirect("/do/msg");
        }else{
            response.sendRedirect("login.html");
        }

    }
}
