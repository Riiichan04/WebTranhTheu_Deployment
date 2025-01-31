package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.info;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "EditInfoController", value = "/user/user-info/edit-info")
public class EditInfoController extends HttpServlet {
    public UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        HttpSession session = request.getSession();
//        User account = (User) session.getAttribute("account");
//        if(account == null){
//            response.sendRedirect("/login");
//        }
//        String fullName = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String gender = request.getParameter("gender");
//        if(fullName!=null && email!=null && phone!=null && gender!=null){
//            account.setFullName(fullName);
//            account.setEmail(email);
//            account.setPhone(phone);
//            account.setGender(Integer.parseInt(gender));
//            account.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//        }
//        userService.updateInfo(account);
//        session.setAttribute("account", account);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        if(account == null){
            response.sendRedirect("/login");
        }
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        System.out.println(fullName);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(gender);
        if(fullName!=null && email!=null && gender!=null){
            account.setFullName(fullName);
            account.setEmail(email);
            account.setPhone(phone);
            account.setGender(Integer.parseInt(gender));
            account.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        }
        userService.updateInfo(account);
        session.setAttribute("account", account);
    }
}