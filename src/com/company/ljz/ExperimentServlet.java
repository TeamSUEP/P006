package com.company.ljz;

import dao.Dao;
import entity.Experiment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExperimentServlet")
public class ExperimentServlet extends HttpServlet {
    private Dao dao=new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opttype=request.getParameter("opttype");
        if("class".equals(opttype)){
            String classno=request.getParameter("classno");
            String courseId=request.getParameter("courseId");
            ArrayList<Experiment> List=dao.allExperimentByclass(classno,courseId);
            request.getSession().setAttribute("List", List);
            response.sendRedirect("teacher/teacher_expetimentStatus.jsp");
        }else if("sno".equals(opttype)) {
            String sno=request.getParameter("sno");
            String courseId = request.getParameter("courseId");
            if (sno==null){//说明是通过学生页面查询的,sno等于学生id
                sno = (String) request.getSession().getAttribute("id");
                ArrayList<Experiment> elist=dao.allExperimentBySno(sno,courseId);
                request.getSession().setAttribute("eList", elist);
                response.sendRedirect("student/Stu_Experiment.jsp");
            }else {
                ArrayList<Experiment> List=dao.allExperimentBySno(sno,courseId);
                request.getSession().setAttribute("List", List);
                response.sendRedirect("teacher/teacher_expetimentStatus.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
