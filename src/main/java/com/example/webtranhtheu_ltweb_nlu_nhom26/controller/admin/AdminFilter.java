package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AdminFilter", value = "/admin/*")
public class AdminFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("auth");
//        if (user == null || user.getRole() != 1) {
//            response.sendRedirect("/login");
//            return;
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}