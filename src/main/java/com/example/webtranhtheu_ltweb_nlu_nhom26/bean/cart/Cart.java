package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Cart implements Serializable {
    private int userId; // xác định sở hữu cart.
    private double totalPrice; // tổng tiền của các sản phẩm trong cart.
    private Map<String, CartProduct> products; // key là Code của Product, Value là 1 CartProduct
    public static final int MAX_CART_PRODUCTS = 10;
    private static Cart instance;
    private Discount discount; // 1 giỏ hàng chỉ áp dụng 1 cart

    private Cart() {
        products = new HashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public boolean addProduct(Product product, Price price, int quantity) {
        if (quantity > price.getAvailable() && quantity > CartProduct.MAX_PER_PRODUCT) return false;
        String productCode;
        if (price == null) {
            productCode = "no price";
        }
        productCode = generateProductCode(product.getId(), price);
        if (products.containsKey(productCode)) {
            return updateProductByQuantity(productCode, quantity); // kiểm tra
        } else {
            CartProduct cartProduct = covertToCart(product.getId());
            cartProduct.setDiscount(product.maxDiscount());
            cartProduct.setQuantity(quantity);
            if (!productCode.equals("no price")) {
                return cartProduct.updateBySize(price);
            }
            cartProduct.setPrice(price);
            // Có xử lý cái total Price ko??
            cartProduct.getFinalPrice();
            this.getTotalPrice();
            products.put(productCode, cartProduct);
            return true;
        }
    }

    private CartProduct covertToCart(int productId) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(productId);
        return cartProduct;
    }

    public boolean updateProductByQuantity(String productCode, int quantity) {
        CartProduct cartProduct = products.get(productCode);
        if (cartProduct != null) {
            if (cartProduct.getPrice().getAvailable() > quantity) {
                cartProduct.setQuantity(quantity);
                cartProduct.getFinalPrice();
                this.getTotalPrice();
            } else return false;
        }
        return false;
    }

    public boolean updateProductByPrice(String productCode, Price price) {
        StringTokenizer str = new StringTokenizer(productCode, "_");
        int productId = Integer.parseInt(str.nextToken());
//        int width= Integer.parseInt(str.nextToken());
//        int height= Integer.parseInt(str.nextToken());
        if (products.containsKey(productCode)) {
            CartProduct oldProduct = products.get(productCode);
            products.remove(productCode);
            String newProductCode = generateProductCode(productId, price);
            if (products.containsKey(newProductCode)) {
                CartProduct product = products.get(newProductCode);
                product.setQuantity(product.getQuantity() + oldProduct.getQuantity());
            } else {
                oldProduct.updateBySize(price);
                products.put(newProductCode, oldProduct);
            }
            this.getTotalPrice();
            return true;
        }
        return false;
    }

    public String generateProductCode(int productId, Price price) {
        return productId + "_" + price.getWidth() + "_" + price.getHeight();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartProduct cartProduct : products.values()) {
            totalPrice += cartProduct.getFinalPrice();
        }
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean removeProduct(String productCode) {
        if (products.containsKey(productCode)) {
            products.remove(productCode);
            this.getTotalPrice();
            return true;
        }
        return false;
    }

    public int getUserId() {
        return userId;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
