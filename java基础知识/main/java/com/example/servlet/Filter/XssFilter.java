package com.example.servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "XssFilter", urlPatterns = "/index")
public class XssFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("init Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String name = request.getParameter("name");
        if (name != null && !name.contains("script")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else  {
            servletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.write("请求包含非法字符，已被拦截！");
            out.flush();
            out.close();
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy Filter");
    }
}
