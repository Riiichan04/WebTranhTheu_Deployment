package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.util.Comparator;
import java.util.List;

public interface ProductUtil {
    //Đây là giá mặc định
    static Price getMinPrice(Product product) {
        return product.getListPrices().stream().min(Comparator.comparingDouble(Price::getPrice)).orElse(null);
    }

    static Price getSelectedPrice(Product product, int width, int height) {
        for (int i = 0; i < product.getListPrices().size(); i++) {
            Price price = product.getListPrices().get(i);
            if (price.getWidth() == width && price.getHeight() == height) return price;
        }
        return null;
    }

    //Mặc định lấy hình đầu tiên làm thumbnail
    static String getThumbnailUrl(Product product) {
        return product.getListImageUrls().get(0);
    }

    //Tạo ra một chuỗi hiển thị thông tin nguyên liệu
    static String getStringDisplayMaterials(Product product) {
        StringBuilder result = new StringBuilder();
        List<String> listTitle = product.getListMaterials().stream().map(Material::getTitle).toList();
        for (String title : listTitle) {
            result.append(title).append(", ");
        }
        //Loại bỏ phần ", " ở kí tự cuối cùng
        return result.substring(0, result.length() - 2);
    }
}
