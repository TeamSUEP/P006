package com.company.ljz;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SetCharacterEncodingFilter")
public class SetCharacterEncodingFilter implements Filter {
    private String encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(this.encoding);
        resp.setCharacterEncoding(this.encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
    }

}
