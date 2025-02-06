package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "GetFormReadUpdateProduct", value = "/admin/product-management/read-edit-product-form")
public class GetFormReadUpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String productId = request.getParameter("productId");
        ProductService productService = new ProductService();
        Product product = productService.getProductById(Integer.parseInt(productId));
        request.setAttribute("product", product);
        List<Material> materials = productService.getMaterials();
        request.setAttribute("materials", materials);
        List<Provider> providers = productService.getProviders();
        request.setAttribute("providers", providers);


        Timestamp timestamp = product.getCreatedAt();
        Timestamp timestampUpdate = product.getUpdatedAt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
        request.setAttribute("createAt", formattedDate);
        String formattedDateUpdate = dateFormat.format(timestampUpdate);
        request.setAttribute("updateAt", formattedDateUpdate);

        request.getRequestDispatcher("/layout/admin/product-form/read-edit-product-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}