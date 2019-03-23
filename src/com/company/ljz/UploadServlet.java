package com.company.ljz;

import dao.Dao;
import com.jspsmart.upload.SmartUpload;
import entity.Experiment;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    private ServletConfig config;

    final public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    final public ServletConfig getServletConfig() {
        return config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SuppressWarnings("Duplicates")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opptype = request.getParameter("opptype");
        if (opptype.equals("upload")){
            String exp_id = (String) request.getSession().getAttribute("exp_id");
            String courseId = (String) request.getSession().getAttribute("courseId");
            String id = (String) request.getSession().getAttribute("id");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset = utf-8");
            SmartUpload su = new SmartUpload();
            try {
                // 上传初始化
                su.initialize(config, request, response);
                su.setAllowedFilesList("doc,txt,docx,pdf,zip,rar,wps");
                // 上传文件
                su.upload();
                //读取当前网站实际物理路径
                String rootpath = config.getServletContext().getRealPath("/WEB-INF/upload/");
                File f = new File(rootpath + id);
                //创建目录
                if (!f.exists())
                    f.mkdir();
                String filename = null;
                for (int i = 0; i < su.getFiles().getCount(); i++) {
                    com.jspsmart.upload.File file = su.getFiles().getFile(i);
                    // 若文件不存在则继续
                    if (file.isMissing())
                        continue;
                    filename = courseId + exp_id+ new Date().getTime() + "." + file.getFileExt();
                    file.saveAs(f.getAbsolutePath() + "/" + filename, su.SAVE_PHYSICAL);
                }
                Dao dao = new Dao();
                dao.uploadExperiment(id, exp_id,courseId, id + "/" + filename);
                out.print("<script language='javascript'>window.location.href='student/Stu_infor.jsp';alert('上传实验成功!');</script>");

            } catch (Exception e) {
                out.println("Unable to upload the file.<br>");
                out.println("Error : " + e.toString());
            }
        }else if (opptype.equals("assignment")){

            Experiment experiment = (Experiment)request.getSession().getAttribute("experiment");
            String id = (String) request.getSession().getAttribute("id");

            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset = utf-8");
            SmartUpload su = new SmartUpload();
            try {
                // 上传初始化
                su.initialize(config, request, response);
                su.setAllowedFilesList("doc,txt,docx,pdf,zip,rar,wps");
                // 上传文件
                su.upload();
                //读取当前网站实际物理路径
                String rootpath = config.getServletContext().getRealPath("/WEB-INF/upload/");
                File f = new File(rootpath + id);
                //创建目录
                if (!f.exists())
                    f.mkdir();
                String filename = null;
                System.out.println(su.getFiles().getCount());
                for (int i = 0; i < su.getFiles().getCount(); i++) {
                    com.jspsmart.upload.File file = su.getFiles().getFile(i);
                    // 若文件不存在则继续
                    if (file.isMissing())
                        continue;
                    filename = experiment.getExp_name() + new Date().getTime() + "." + file.getFileExt();
                    file.saveAs(f.getAbsolutePath() + "/" + filename, su.SAVE_PHYSICAL);
                }
                Dao dao = new Dao();
                experiment.setContent( id + "/" + filename);
                dao.assignment(experiment);
                out.print("<script language='javascript'>window.location.href='teacher/teacher_infor.jsp';alert('上传实验成功!');</script>");

            } catch (Exception e) {
                out.println("Unable to upload the file.<br>");
                out.println("Error : " + e.toString());
            }
        }



    }

    /**
     * Destroy the servlet
     */
    public void destroy() {
    }
}
