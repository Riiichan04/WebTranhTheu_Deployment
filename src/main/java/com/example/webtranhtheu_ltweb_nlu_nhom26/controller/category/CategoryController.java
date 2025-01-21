package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "category", value = "/category/*")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();
//        if (session.getAttribute("listCategory") == null) {
//            session.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
//        }

        String pathName = request.getPathInfo();
        StringTokenizer tokenizer = new StringTokenizer(pathName, "/");
        String categoryName = tokenizer.nextToken();

        if (CategoryService.isCategoryNameExist(categoryName)) {
            List<Category> listCategory = CategoryService.getNameAndPatternCategory();
            request.setAttribute("listCategoryName", listCategory);
            //Cần tối ưu
            request.setAttribute("categoryTitle", CategoryService.getCategoryTitleByPatternName(listCategory, categoryName));
            request.setAttribute("categoryName", categoryName);
            request.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
            request.getRequestDispatcher("/layout/category.jsp").forward(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}