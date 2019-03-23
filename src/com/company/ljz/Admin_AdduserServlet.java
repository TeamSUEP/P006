package com.company.ljz;

import dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Admin_AdduserServlet")
public class Admin_AdduserServlet extends HttpServlet {
    Dao dao =new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user_type=request.getParameter("user_type");
        if (user_type.equals("student")){
            String stuId = request.getParameter("stuId");
            String stuName = request.getParameter("stuName");
            String classno = request.getParameter("classno");
            if (dao.queryByStuID(stuId).isEmpty()){
                dao.InsertStu(stuId,stuName,classno);
                out.print("<script language='javascript'>window.location.href='admin/adimin_adduser.jsp';alert('添加成功!初始密码为123456');</script>");
            }else {
                out.print("<script language='javascript'>window.location.href='admin/adimin_adduser.jsp';alert('您输入的学生学号已存在!');</script>");
            }
        }else if (user_type.equals("teacher")){
            String teaId = request.getParameter("teaId");
            String teaName = request.getParameter("teaName");
            if (dao.queryByTeaID(teaId).isEmpty()){
                dao.InsertTea(teaId,teaName);
                out.print("<script language='javascript'>window.location.href='admin/adimin_adduser.jsp';alert('添加成功!初始密码为123456');</script>");
            }else
                out.print("<script language='javascript'>window.location.href='admin/adimin_adduser.jsp';alert('您输入的教师号已存在!');</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
