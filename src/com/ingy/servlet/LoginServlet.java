package com.ingy.servlet;

import com.ingy.pojo.User;
import com.ingy.service.LoginService;
import com.ingy.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/*
    1）
    2）使用Cookie实现一段时间内免密登录
    3）使用session实现用户信息共享
    4）使用ServletContext实现网络计数器
*/

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        //获取请求信息
        String uname=req.getParameter("uname");
//        uname = new String(uname.getBytes("iso8859-1"),"utf-8");
        String pwd=req.getParameter("pwd");
        System.out.println(uname+":"+pwd);

        //处理请求
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname, pwd);
        System.out.println(u);

        //应答处理结果
        if(u!=null) {
            //创建Cookie信息实现5分钟免登陆
            Cookie c=new Cookie("uid",u.getUid()+"");

            //设置Cookie的有效期
            c.setMaxAge(5*60); //5分钟
            c.setPath("ck");
            //添加Cookie信息
            resp.addCookie(c);
            System.out.println("添加Cookie!");

//            Cookie[] cks=req.getCookies();
//            for (Cookie ck:cks) {
//                String n = ck.getName();
//                String v = ck.getValue();
////                System.out.println(n + ":" + v);
//            }

            //将数据存储到session中
            HttpSession hs=req.getSession();
            hs.setAttribute("user",u);

            //网页计数器
            ServletContext sc=req.getServletContext();
            if(null != sc.getAttribute("count")) {
                int count = (int) sc.getAttribute("count");
                //计数自增
                count++;
                //存ServletContext
                sc.setAttribute("count", count);
            } else {
                sc.setAttribute("count", 1);
            }

            //重定向
            req.getRequestDispatcher("main").forward(req,resp);
        } else {
//            resp.getWriter().write("登陆失败！");
            //实现servlet的数据流转
            req.setAttribute("str","用户名或者密码错误！");
            //请求转发，多个servlet配合工作，避免职责不单一的情况
            req.getRequestDispatcher("page").forward(req,resp);
        }
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
