package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
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

    public static List<Category> getNameAndPatternCategory() {
        return categoryDAO.getAllCategoriesName();
    }

    public static int getIndexPatternName(List<Category> categories, String patternName) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getPatternName().equals(patternName)) {
                return i;
            }
        }
        return -1;
    }

    public static String getCategoryTitleByPatternName(List<Category> listCategory, String patternName) {
        for (Category category : listCategory) {
            if (category.getPatternName().equals(patternName)) return category.getTitle();
        }
        return null;
    }

    //Method tạm cho báo cáo. Sẽ xóa và thay bằng filter hoàn chỉnh
    public static List<Product> getDisplayProductByCategoryAndName(String categoryName, int offset, int amount, List<Integer> listId) {
        List<Integer> listProductId = categoryDAO.filterProductIdWithNameAndCategory(categoryName, (offset - 1), amount, listId);
        List<Product> listProduct = new ArrayList<>();
        for (int productId : listProductId) {
            listProduct.add(new DisplayCardProduct(new ConcreateProductDetail()).getDisplayProductInfo(productId));
        }
        return listProduct;
    }
}
