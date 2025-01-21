package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.error;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ErrorController", value = "/error")
public class ErrorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("listCategory") == null) {
            session.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
        }
        request.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
        request.getRequestDispatcher("layout/error.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}