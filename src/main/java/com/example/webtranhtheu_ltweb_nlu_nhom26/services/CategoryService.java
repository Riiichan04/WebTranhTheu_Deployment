package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.CategoryDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreteProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class CategoryService {
    static CategoryDAO categoryDAO = JDBIConnector.getInstance().onDemand(CategoryDAO.class);

    public CategoryService() {
        categoryDAO = JDBIConnector.getInstance().onDemand(CategoryDAO.class);
    }

    //Dùng cho trang admin
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

    public String removeDiacritics(String input) {
        String normalized = Normalizer.normalize(input.toLowerCase(), Normalizer.Form.NFD);
        // Loại bỏ các ký tự không phải ASCII
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String result = pattern.matcher(normalized).replaceAll("").replace("đ", "d").replace("Đ", "D");
        result = result.replace("\s", "-");
        return result;
    }

    //Dùng cho trang danh mục
    //Lấy amount sản phẩm tính từ offset
    public static List<Integer> getListProductIdByCategory(String categoryName, int offset, int amount) {
        return categoryDAO.getListIdInCategory(categoryName, (offset - 1), amount);
    }

    public static List<Product> getDisplayProductByCategory(String categoryName, int offset, int amount) {
        List<Integer> listProductId = categoryDAO.getListIdInCategory(categoryName, (offset - 1) * amount, amount);
        List<Product> listProduct = new ArrayList<>();
        for (int productId : listProductId) {
            listProduct.add(new DisplayCardProduct(new ConcreteProductDetail()).getDisplayProductInfo(productId));
        }
        return listProduct;
    }

    public static boolean isCategoryNameExist(String categoryName) {
        return categoryName.equals(categoryDAO.getCategoryPatternName(categoryName));
    }

    public static int calculateCategoryPage(String categoryName, List<Integer> listTopicId, int rating, double fromPrice, double toPrice, String providerName, String productName, int amount) {
        Integer countProduct = categoryDAO.countProductByCategory(categoryName, listTopicId, rating, fromPrice, toPrice, providerName, productName);
        if (countProduct == null) countProduct = 0;
        int baseVal = countProduct / amount;
        return countProduct % amount == 0 ? baseVal : baseVal + 1;
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
}
