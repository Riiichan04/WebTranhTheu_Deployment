package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.CloudinaryConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "AddProductController", value = "/admin/product-management/add-product")
@MultipartConfig
public class AddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String code = request.getParameter("codeProduct");
            String title = request.getParameter("title");
            String description = request.getParameter("description");

            List<String> imgUrl = new ArrayList<>();
            for (Part part : request.getParts()) {
                String contentDisp = part.getHeader("content-disposition");
                if (contentDisp != null && contentDisp.contains("filename")) {
                    imgUrl.add(CloudinaryConfig.getUrl(part));
                }
            }

            String[] prices = request.getParameterValues("price");
            String[] quantity = request.getParameterValues("quantity");
            String[] width = request.getParameterValues("width");
            String[] height = request.getParameterValues("height");
            List<Price> listPrices = new ArrayList<>();
            for (int i = 0; i < prices.length; i++) {
                Price p = new Price(Integer.parseInt(width[i]), Integer.parseInt(height[i]), Double.parseDouble(prices[i]), Integer.parseInt(quantity[i]));
                listPrices.add(p);
            }

            String[] material = request.getParameterValues("material");

            String provider = request.getParameter("provider");

            String status = request.getParameter("status");

            String type = request.getParameter("type");

            Product product = new Product(code, title, description, Integer.parseInt(status), Integer.parseInt(type));

            ProductService productService = new ProductService();
            productService.addProduct(product, Integer.parseInt(provider), material, listPrices, imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}