package com.ingy.servlet;

import com.ingy.pojo.User;
import com.ingy.service.LoginService;
import com.ingy.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
                    System.out.println("Cookie信息: " + name+":" + value);

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

                            req.getRequestDispatcher("main").forward(req,resp);
                            return;
                        } else {
                            //请求转发
                            req.getRequestDispatcher("page").forward(req,resp);
                            return;
                        }
                    }
                }
            } else {
                //响应处理结果
                //请求转发
                req.getRequestDispatcher("page").forward(req,resp);
            }

        //处理请求信息
            //直接响应

            //重定向
        //
    }
}
