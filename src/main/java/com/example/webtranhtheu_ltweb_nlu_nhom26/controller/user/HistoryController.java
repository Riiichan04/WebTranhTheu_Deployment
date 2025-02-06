package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.history.ViewedHistory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "HistoryController", value = "/user/history")
public class HistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try{
            User account=(User) session.getAttribute("account");
            if(account == null){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }else{
                ViewedHistory viewedHistory= (ViewedHistory) session.getAttribute("viewedHistory");
                if(viewedHistory == null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    session.setAttribute("viewedHistory", viewedHistory);
                    request.getRequestDispatcher("/layout/user/user-viewed-info.jsp").forward(request, response);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}