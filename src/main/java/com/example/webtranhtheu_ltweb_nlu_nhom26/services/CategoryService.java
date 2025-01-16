package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.CategoryDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    static CategoryDAO categoryDAO = JDBIConnector.getInstance().onDemand(CategoryDAO.class);

    //Lấy amount sản phẩm tính từ offset
    public static List<Integer> getListProductIdByCategory(String categoryName, int offset, int amount) {
        return categoryDAO.getListIdInCategory(categoryName, (offset - 1), amount);
    }

    public static List<Product> getDisplayProductByCategory(String categoryName, int offset, int amount) {
        List<Integer> listProductId = categoryDAO.getListIdInCategory(categoryName, (offset - 1) * amount, amount);
        List<Product> listProduct = new ArrayList<>();
        for (int productId : listProductId) {
            listProduct.add(new DisplayCardProduct(new ConcreateProductDetail()).getDisplayProductInfo(productId));
        }
        return listProduct;
    }

    public static boolean isCategoryNameExist(String categoryName) {
        return categoryName.equals(categoryDAO.getCategoryPatternName(categoryName));
    }

    public static int calculateCategoryPage(String categoryName, int amount) {
        int baseVal = categoryDAO.countProductByCategory(categoryName) / amount;
        return categoryDAO.countProductByCategory(categoryName) % amount == 0 ? baseVal : baseVal + 1;
    }
}
