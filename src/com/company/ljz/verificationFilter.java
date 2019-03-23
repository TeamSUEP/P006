package com.company.ljz;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "verificationFilter")
public class verificationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //通过过滤器进行登录过滤，不是进行合法用户名密码登录的，不可以跳转到下一页面，防止通过路径直接访问网页
        HttpServletRequest requ=(HttpServletRequest)req;
        HttpServletResponse res=(HttpServletResponse)resp;
        String id = (String)requ.getSession().getAttribute("id");
        if(id==null){
            res.sendRedirect("../login.jsp");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
