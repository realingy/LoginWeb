package com.ingy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
    }

    @Override
    public void init() throws ServletException {

        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");

        //获取文件路径
        String path=this.getServletContext().getRealPath("count/count.txt");
        //声明流对象
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr=new FileReader(path);
            br=new BufferedReader(fr);
            String count = br.readLine();
            this.getServletContext().setAttribute("count", count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        //获取网页计数
        int count = (int)this.getServletContext().getAttribute("count");
        //获取文件路径
        String path=this.getServletContext().getRealPath("count/count.txt");
        //声明流对象
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw=new FileWriter(path);
            bw=new BufferedWriter(fw);
            bw.write(count+"");
            bw.flush();//刷新流
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
