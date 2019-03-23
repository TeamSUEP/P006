package com.company.ljz;

import dao.Dao;
import entity.Student;
import entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Admin_InforServlet")
public class Admin_InforServlet extends HttpServlet {
    Dao dao =new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opttype=request.getParameter("opttype");
        if("search".equals(opttype)){
            String user_type = request.getParameter("user_type");
            if (user_type.equals("student")){
                String by = request.getParameter("by");
                if (by.equals("stuId")){
                    try {
                        String stuId = request.getParameter("stuId");
                        ArrayList<Student> stulist=dao.queryByStuID(stuId);
                        if (stulist.isEmpty()){
                            out.print("<script language='javascript'>window.location.href='admin/admin_studentInfor.jsp';alert('您输入的学生学号不存在!');</script>");
                        }else {
                            request.getSession().setAttribute("stulist", stulist);
                            response.sendRedirect("admin/admin_studentInfor.jsp");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if (by.equals("classno")){
                    try {
                        String classno = request.getParameter("classno");
                        ArrayList<Student> stulist=dao.queryByClassno(classno);
                        if (stulist.isEmpty()){
                            out.print("<script language='javascript'>window.location.href='admin/admin_studentInfor.jsp';alert('您输入的班级号不存在!');</script>");
                        }else {
                            request.getSession().setAttribute("stulist", stulist);
                            response.sendRedirect("admin/admin_studentInfor.jsp");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }else if (user_type.equals("teacher")){

                try {
                    String teaId = request.getParameter("teaId");
                    ArrayList<Teacher> tealist=dao.queryByTeaID(teaId);
                    if (tealist.isEmpty()){
                        out.print("<script language='javascript'>window.location.href='admin/admin_teacherInfor.jsp';alert('您输入的教师号不存在!');</script>");
                    }else {
                        request.getSession().setAttribute("tealist", tealist);
                        response.sendRedirect("admin/admin_teacherInfor.jsp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }else if("repair".equals(opttype)){
            String user_type = request.getParameter("user_type");
            if (user_type.equals("student")){
                String stuId = request.getParameter("stuId");
                String classId = request.getParameter("classId");
                String stuName = request.getParameter("stuName");
                ArrayList<Student> stulist=dao.queryByStuID(stuId);
                if (stulist.isEmpty()){//查询学生号是否存在
                    out.print("<script language='javascript'>window.location.href='admin/admin_studentInfor.jsp';alert('您输入的学生学号不存在!');</script>");
                }else {
                    dao.repairStuInf(stuId,stuName,classId);
                    try {
                        stulist=dao.queryByStuID(stuId);
                        request.getSession().setAttribute("stulist", stulist);
                        response.sendRedirect("admin/admin_studentInfor.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if (user_type.equals("teacher")){
                String teaId = request.getParameter("teaId");
                String teaName = request.getParameter("teaName");
                ArrayList<Teacher> tealist = dao.queryByTeaID(teaId);
                if (tealist.isEmpty())
                    out.print("<script language='javascript'>window.location.href='admin/admin_teacherInfor.jsp';alert('您输入的教师学号不存在!');</script>");
                else{
                    dao.repairTeaInf(teaId,teaName);
                    tealist = dao.queryByTeaID(teaId);
                    request.getSession().setAttribute("tealist", tealist);
                    response.sendRedirect("admin/admin_teacherInfor.jsp");
                }

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
