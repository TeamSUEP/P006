package com.company.ljz;

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private ServletConfig config;

    final public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    final public ServletConfig getServletConfig() {
        return config;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        String fileName = request.getParameter("fileName");
        // 新建一个smartUpload对象
        SmartUpload smartUpload = new SmartUpload();
        // 初始化
        smartUpload.initialize(this.getServletConfig(), request, response);
        // 设定contentDisposition为null以禁止浏览器自动打开文件
        // 保证单击链接后是下载文件。
        smartUpload.setContentDisposition(null);
        // 下载文件（要下载的文件位置）
        String rootpath = config.getServletContext().getRealPath("/WEB-INF/upload/");
        String realname = fileName.substring(9);//1
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(rootpath+ fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
