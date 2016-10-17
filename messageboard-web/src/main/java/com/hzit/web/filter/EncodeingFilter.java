package com.hzit.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13.
 */
public class EncodeingFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("程序被销毁的时候才会被调用的方法，一般用来放置一些清除资源的代码");
    }
    //过滤器每次拦截的时候要执行的代码
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("拦截了一次");
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        //从会话中获取一个叫name的属性值
        Object obj=request.getSession().getAttribute("name");
        //如果会话没有信息，代表用户没有登录成功过
//        if (obj==null){
//            response.sendRedirect(request.getContextPath()+"/login.html");
//            //停止方法的继续运行
//            return;
//        }
        //允许继续运行后面的请求，必须要写这句，否则过滤器出不去
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("初始化的时候执行的代码块，一般在过滤器启动的时候就会被创建，该方法就会被执行");
    }

}
