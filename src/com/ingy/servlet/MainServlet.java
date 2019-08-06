package com.ingy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        //响应请求结果
        //获取request的作用域数据
        String str = (String) req.getAttribute("uname");
//            System.out.println(str);

            resp.getWriter().write("<html>");
            resp.getWriter().write("<head>");
            resp.getWriter().write("</head>");
            resp.getWriter().write("<body>");
            resp.getWriter().write("<form action='login' method='get'>");
            resp.getWriter().write("<table width='50%>'");
            resp.getWriter().write("<tr>");
            resp.getWriter().write("<td>&nbsp</td><td><b>欢迎"+str+"访问教学系统<b></td>");
            resp.getWriter().write("</tr>");
            resp.getWriter().write("</form>");
            resp.getWriter().write("</body>");
            resp.getWriter().write("</html>");
    }
}
