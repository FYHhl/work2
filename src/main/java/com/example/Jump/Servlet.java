package com.example.Jump;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Servlet extends HttpServlet {
    Connection connection=null;
    PreparedStatement statement =null;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取连接
            connection = DBUtil.getConnection();
            //创建sql语句
            String sql="select * from t_teacher";
            //获取语句对象
            statement = connection.prepareStatement(sql);
            //查询
            ResultSet resultSet = statement.executeQuery();
            //创建一个老师列表，集合
            List<Teacher> teacherList=new ArrayList<>();
            while(resultSet.next()) {
                //获取每一行数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                //封装每一个老师
                Teacher teacher = new Teacher(id, name);
                //加入到集合中
                teacherList.add(teacher);
            }
            //把教师列表集合放入最大的域中
            req.getServletContext().setAttribute("teacherList",teacherList);
            // 重定向跳转页面
            resp.sendRedirect("teacher.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭结果集
            try {
                //第6步：释放资源
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取连接
            connection = DBUtil.getConnection();
            //创建sql语句
            String sql="select * from t_teacher";
            //获取语句对象
            statement = connection.prepareStatement(sql);
            //查询
            ResultSet resultSet = statement.executeQuery();
            //创建一个老师列表，集合
            List<Teacher> teacherList=new ArrayList<>();
            while(resultSet.next()) {
                //获取每一行数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                //封装每一个老师
                Teacher teacher = new Teacher(id, name);
                //加入到集合中
                teacherList.add(teacher);
            }
            //把教师列表集合放入最大的域中
            req.getServletContext().setAttribute("teacherList",teacherList);
            // 重定向跳转页面
            resp.sendRedirect("teacher.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭结果集
            try {
                //第6步：释放资源
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
