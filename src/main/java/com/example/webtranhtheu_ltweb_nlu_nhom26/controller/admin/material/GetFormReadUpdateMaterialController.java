package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.material;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.MaterialService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(name = "GetFormReadUpdateMaterialController", value = "/admin/material-management/read-edit-material-form")
public class GetFormReadUpdateMaterialController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int materialId = request.getParameter("materialId") == null ? -1 : Integer.parseInt(request.getParameter("materialId"));

        Material m = MaterialService.getMaterialById(materialId);

        if (m == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.setAttribute("material", m);

            Timestamp timestamp = m.getCreatedAt();
            Timestamp timestampUpdate = m.getUpdatedAt();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
            request.setAttribute("createAt", formattedDate);
            String formattedDateUpdate = dateFormat.format(timestampUpdate);
            request.setAttribute("updateAt", formattedDateUpdate);

            request.getRequestDispatcher("/layout/admin/material-form/read-edit-material-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}