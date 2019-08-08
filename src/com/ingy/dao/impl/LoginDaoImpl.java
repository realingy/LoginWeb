package com.ingy.dao.impl;

import com.ingy.dao.LoginDao;
import com.ingy.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {

        User u=null;

        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "";

        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            System.out.println("加载驱动成功！");

            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if(!con.isClosed())
                System.out.println("数据库连接成功!");

            //查询数据

            //要执行的SQL语句
            String sql = "select * from t_user where uname=? and pwd=?";
            //创建sql命令对象
            PreparedStatement ps = con.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            //ResultSet类，用来存放获取的结果集！
            ResultSet rs = ps.executeQuery();

            //
            while(rs.next()) {
                //获取uid这列数据
                int i = rs.getInt("uid");
                //获取uname这列数据
                String n = rs.getString("uname");
                //获取pwd
                String p = rs.getString("pwd");

                u = new User();
                u.setUid(i); //设置uid
                u.setUname(n); //设置uname
                u.setPwd(p); //设置password

                //输出结果
                System.out.println(i + "\t" + uname + "\t" + pwd);
            }

//            //4. 删除数据
//            PreparedStatement psql;
//
//            psql = con.prepareStatement("delete from student where id = ?");
//            psql.setString(1, "2005");
//            psql.executeUpdate();
//            System.out.println("数据删除完成！");
//
//            //5. 增加数据,增加之前先判断
//            sql = "select * from student where id = 2005";
//            rs = statement.executeQuery(sql);
//
//            if(false == rs.next()) {
//                //预处理添加数据 其中有两个参数--“？”
//                psql = con.prepareStatement("insert into student (id,name,sex,birthday) "
//                        + "values(?,?,?,?)");
//                psql.setString(1, "2005");
//                psql.setString(2, "王刚");
//                psql.setString(3, "1");
//
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date myDate2 = dateFormat.parse("2010-09-13");
//                psql.setDate(4,new java.sql.Date(myDate2.getTime()));
//                psql.executeUpdate();
//                System.out.println("数据添加完成！");
//            }

            //6. 改数据
//            psql = con.prepareStatement("update student set name = ? where id = ? ");
//            psql.setString(1, "张刚");
//            psql.setString(2, "2005");
//            psql.executeUpdate();
//            System.out.println("数据更新完成！");

//            psql.close();
            ps.close();
            rs.close();
            con.close();
        } catch(Exception e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
            return u;
        }
    }

    @Override
    public User checkLoginDao(String uid) {
        User u=null;

        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";

        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            System.out.println("加载驱动成功！");

            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if(!con.isClosed())
                System.out.println("数据库连接成功!");

            //查询数据

            //要执行的SQL语句
            String sql = "select * from t_user where uid=?";
            //创建sql命令对象
            PreparedStatement ps = con.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uid);
//            ps.setInt(1, Integer.parseInt(uid));
            //ResultSet类，用来存放获取的结果集！
            ResultSet rs = ps.executeQuery();

//            System.out.println("##########################"+uid);
            while(rs.next()) {
                //获取uid这列数据
                int i = rs.getInt("uid");
                //获取uname这列数据
                String n = rs.getString("uname");
                //获取pwd
                String p = rs.getString("pwd");

                u = new User();
                u.setUid(i); //设置uid
                u.setUname(n); //设置uname
                u.setPwd(p); //设置password

                //输出结果
                System.out.println(i + "\t" + uid + "\t");
            }

//            //4. 删除数据
//            PreparedStatement psql;
//
//            psql = con.prepareStatement("delete from student where id = ?");
//            psql.setString(1, "2005");
//            psql.executeUpdate();
//            System.out.println("数据删除完成！");
//
//            //5. 增加数据,增加之前先判断
//            sql = "select * from student where id = 2005";
//            rs = statement.executeQuery(sql);
//
//            if(false == rs.next()) {
//                //预处理添加数据 其中有两个参数--“？”
//                psql = con.prepareStatement("insert into student (id,name,sex,birthday) "
//                        + "values(?,?,?,?)");
//                psql.setString(1, "2005");
//                psql.setString(2, "王刚");
//                psql.setString(3, "1");
//
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date myDate2 = dateFormat.parse("2010-09-13");
//                psql.setDate(4,new java.sql.Date(myDate2.getTime()));
//                psql.executeUpdate();
//                System.out.println("数据添加完成！");
//            }

            //6. 改数据
//            psql = con.prepareStatement("update student set name = ? where id = ? ");
//            psql.setString(1, "张刚");
//            psql.setString(2, "2005");
//            psql.executeUpdate();
//            System.out.println("数据更新完成！");

//            psql.close();
            ps.close();
            rs.close();
            con.close();
        } catch(Exception e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
            return u;
        }
    }
}
