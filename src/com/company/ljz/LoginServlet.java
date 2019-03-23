package com.company.ljz;

import dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private Dao dao=new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String user_type = request.getParameter("user_type");
        PrintWriter out = response.getWriter();
        if (dao.Verification(id,password,user_type) == true){
            String name = dao.getName(id,user_type);
            request.getSession().setAttribute("id",id);
            request.getSession().setAttribute("user_type",user_type);
            request.getSession().setAttribute("name",name);
            switch (user_type){
                case "students":
                    response.sendRedirect("student/Stu_infor.jsp");
                    break;
                case "teachers":
                    response.sendRedirect("teacher/teacher_infor.jsp");
                    break;
                case "admins" :
                    response.sendRedirect("admin/admin_infor.jsp");
                    break;
            }
        }else
            out.print("<script language='javascript'>window.location.href='login.jsp';alert('您的账户或密码有误!');</script>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
