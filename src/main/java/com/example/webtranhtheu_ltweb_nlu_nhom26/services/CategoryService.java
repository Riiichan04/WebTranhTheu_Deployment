package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.CategoryDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.sql.Timestamp;
import java.util.List;

public class CategoryService {
    private static CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = JDBIConnector.getInstance().onDemand(CategoryDAO.class);
    }
    public List<CategoryDTO> getCategoriesDTO() {
        return categoryDAO.getListCategoryDTO();
    }

    public boolean addCategory(Category category) {
        return categoryDAO.insertCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    public List<Product> listProductInCategory(int categoryId) {
        return categoryDAO.getProductsByCategoryId(categoryId);
    }

    public List<Product> listProductNotInCategory(int categoryId) {
        return categoryDAO.getProductsNotInCategory(categoryId);
    }

    public void updateCategory(Category category, String[] deleteProductsId, String[] addProductsId) {
        categoryDAO.updateCategory(category);
        for(String productId : deleteProductsId) {
            categoryDAO.deleteCategory(Integer.parseInt(productId), category.getId());
        }
        for(String productId : addProductsId) {
            categoryDAO.insertCategoryProducts(category.getId(), Integer.parseInt(productId), new Timestamp(System.currentTimeMillis()));
        }
    }
}
