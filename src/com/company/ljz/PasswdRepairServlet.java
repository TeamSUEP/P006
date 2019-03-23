package com.company.ljz;

import dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PasswdRepairServlet")
public class PasswdRepairServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opttype=request.getParameter("opttype");
        if("repair".equals(opttype)){//修改密码
            String newPassword = request.getParameter("newPassword");
            String newPassword2 = request.getParameter("newPassword2");
            PrintWriter out = response.getWriter();
            if (newPassword.equals(newPassword2))
            {
                Dao dao =new Dao();
                HttpSession session = request.getSession();
                dao.updatePassword((String) session.getAttribute("user_type"),newPassword,(String) session.getAttribute("id"));
                out.print("<script language='javascript'>window.location.href='login.jsp';alert('success!');</script>");
            }else
                out.print("<script language='javascript'>window.location.href='student/Stu_passwdRepair.jsp';alert('您输入的密码不一致!');</script>");
        }else if("reset".equals(opttype)){//重置密码
            String stuId=request.getParameter("stuId");
            String teaId=request.getParameter("teaId");
            Dao dao =new Dao();
            PrintWriter out = response.getWriter();
            if (stuId != null)
            dao.resetPassword("students",stuId);
            else if (teaId != null)
                dao.resetPassword("teachers",teaId);
            out.print("<script language='javascript'>window.location.href='admin/admin_passRepair.jsp';alert('成功! 你的重置密码是123456 请尽快进行修改');</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
