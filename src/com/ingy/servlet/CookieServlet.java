package com.ingy.servlet;

import com.ingy.pojo.User;
import com.ingy.service.LoginService;
import com.ingy.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录校验，实现三天免登陆功能
        //判断请求中是否携带正确的Cookie信息，如果有则校验Cookie信息是否正确
            //校验通过则响应主页面给用户
            //校验失败则响应登录页面给用户
        //没有Cookie则通过重定向转发请求到登陆页面

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取Cookie信息
            Cookie[] cks=req.getCookies();
            if(cks != null) {
                String uid="";
                for (Cookie c:cks) {
                    String name=c.getName();
                    String value=c.getValue();
                    System.out.println(name+":"+value);

                    if("uid".equals(c.getName())) {
                        uid=c.getValue();
                    }

                    if("".equals(uid)) {
                        //请求转发
                        req.getRequestDispatcher("page").forward(req,resp);
                        return;
                    } else {
                        //到数据库中校验用户信息
                        LoginService ls=new LoginServiceImpl();
                        User u=ls.checkLoginService(uid);
                        if(u!=null) {
//                            resp.getWriter().write("登陆成功！");
                            req.getRequestDispatcher("main").forward(req,resp);
                            return;
                        } else {
                            System.out.println("11111111111111111111111111");
                            //请求转发
                            req.getRequestDispatcher("page").forward(req,resp);
                            return;
                        }
                    }
                }
            } else {
                //响应处理结果
                //请求转发
                System.out.println("22222222222222222222222222222");
                req.getRequestDispatcher("page").forward(req,resp);
            }

        //处理请求信息
            //直接响应

            //重定向
        //
    }
}
