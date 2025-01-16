package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.AuthDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        Integer userId = session != null ? (Integer) session.getAttribute("accountId") : null;

        // Kiểm tra nếu userId là null (chưa đăng nhập)
        if (userId == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        } else {
            // Kiểm tra quyền admin
            AuthDTO auth = new AuthService().getAuthById(userId);
            // Kiểm tra vai trò và trạng thái tài khoản
            if (auth.getRole() != 1 || auth.getStatusAccount() != 2) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }

        // Nếu mọi điều kiện hợp lệ, tiếp tục filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
