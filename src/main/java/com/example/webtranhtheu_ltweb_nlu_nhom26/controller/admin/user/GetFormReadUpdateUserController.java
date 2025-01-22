package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(name = "GetFormReadUpdateUserController", value = "/admin/user-management/read-edit-user-form")
public class GetFormReadUpdateUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int userId = request.getParameter("userId") == null ? -1 : Integer.parseInt(request.getParameter("userId"));
        UserService userService = new UserService();
        User u = userService.getUserById(userId);
        if (u == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.setAttribute("user", u);
            Timestamp timestamp = u.getCreatedAt();
            Timestamp timestampUpdate = u.getUpdatedAt();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
            request.setAttribute("createAt", formattedDate);
            String formattedDateUpdate = dateFormat.format(timestampUpdate);
            request.setAttribute("updateAt", formattedDateUpdate);

            ProductService productService = new ProductService();
            request.setAttribute("listProducts", productService.getAllListProductsCodeAndTitle());

            request.getRequestDispatcher("/layout/admin/user-form/read-edit-user-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}