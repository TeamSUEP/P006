package com.company.ljz;

import dao.Dao;
import entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "courseServlet")
public class courseServlet extends HttpServlet {
    private Dao dao=new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = (String) request.getSession().getAttribute("id");
        ArrayList<Course> courselist = dao.courseStatus(id);
        if (courselist.isEmpty()){
            out.print("<script language='javascript'>window.location.href='Stu_infor.jsp';alert('您尚未选修任何课程,无法查询您的试验情况!');</script>");
        }else {
            request.getSession().setAttribute("courselist", courselist);
            response.sendRedirect("student/Stu_course.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
