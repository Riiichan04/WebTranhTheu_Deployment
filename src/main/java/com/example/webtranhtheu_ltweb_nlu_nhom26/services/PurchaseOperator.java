package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PurchaseOperator {
    //Nhận các Cart và nhận mảng productCode
    public static synchronized boolean performPurchase(int accountId, String address, int method, Cart cart, Map<String, CartProduct> listProductCode) {
        //Còn sửa sau
        // - Gọi sql giảm số lượng available tương ứng theo mức giá
        // - Trả về kết quả cuối cùng
        boolean result = OrderService.createOrder(accountId, address, method, listProductCode.values().stream().toList());
        if (result) {
            // - Tìm các product tương ứng
            // - Thực hiện cập nhật thông tin trong Cart được truyền vào
            List<String> keySet = listProductCode.keySet().stream().toList();
            for (int i = 0; i < keySet.size(); i++) {
                cart.getProducts().remove(keySet.get(i));
            }
//            listProductCode.keySet().forEach(key -> cart.getProducts().remove(key));
            return true;
        }
        else return false;
    }
}
