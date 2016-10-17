package com.hzit.web.servlet;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.entity.Userinfo;
import com.hzit.dao.vo.MessageboardVo;
import com.hzit.web.services.MessageboardServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */

public class MessageBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             Userinfo u= (Userinfo) request.getSession().getAttribute("user");
        String p=request.getParameter("p");
        if (p==null){
            p="1";
        }
        if (u!=null){
            Integer userid=u.getUserId();
            MessageboardServiesImpl messageboardServiesImpl=new MessageboardServiesImpl();
            List<MessageboardVo> list=messageboardServiesImpl.findMessage(userid,Integer.parseInt(p));
            request.setAttribute("pages",p);
            request.setAttribute("list",list);
            request.setAttribute("count",messageboardServiesImpl.getpages(userid));
            request.getRequestDispatcher("../WEB-INF/views/index.jsp").forward(request,response);
        }
    }
}
