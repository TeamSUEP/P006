package com.company.ljz;

import entity.Experiment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "jumpServlet")
public class jumpServlet extends HttpServlet {
    //区分学生上传还是老师布置实验
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String opttype = request.getParameter("opttype");
        if (opttype.equals("upload")){
            String exp_id = request.getParameter("exp_id");
            String courseId = request.getParameter("courseId");
            request.getSession().setAttribute("exp_id",exp_id);
            request.getSession().setAttribute("courseId",courseId);
            response.sendRedirect("student/Stu_fileupload.jsp");
        }else if ("assignment".equals(opttype)){
            String classno =request.getParameter("classno");
            String courseId =request.getParameter("courseId");
            String experName =request.getParameter("name");
            String demand =request.getParameter("demand");

            Experiment experiment = new Experiment();
            experiment.setClassno(classno);
            experiment.setCourseId(courseId);
            experiment.setExp_name(experName);
            experiment.setDemand(demand);

          request.getSession().setAttribute("experiment",experiment);
            response.sendRedirect("teacher/teacher_fileupload.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
