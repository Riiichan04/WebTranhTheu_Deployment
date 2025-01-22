package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Cart implements Serializable {
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
        productCode = generateProductCode(product.getId(), price.getWidth(), price.getHeight());
        if (products.containsKey(productCode)) {
            CartProduct cartProduct = products.get(productCode);
            return updateProductByQuantity(productCode, cartProduct.getQuantity() + quantity); // kiểm tra
        } else {
            CartProduct cartProduct = covertToCart(product);
            cartProduct.setQuantity(quantity);
            if (productCode.equals("no price")) {
                return false;
            }
            cartProduct.updateBySize(price.getWidth(), price.getHeight());
            cartProduct.setPrice(price);
            // Có xử lý cái total Price ko??
            cartProduct.getTotalPrice();
            products.put(productCode, cartProduct);
            this.getTotalPrice();
            return true;
        }
    }


    private CartProduct covertToCart(Product product) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(product.getId());
        cartProduct.setTitle(product.getTitle());
        cartProduct.setThumbnailUrl(product.getThumbnail());
        cartProduct.setPrices(product.getListPrices());
        return cartProduct;
    }

    public boolean updateProductByQuantity(String productCode, int quantity) {
        CartProduct cartProduct = products.get(productCode);
        if (cartProduct != null) {
            if (cartProduct.getPrice().getAvailable() > quantity) {
                if (quantity>0 && quantity <= CartProduct.MAX_PER_PRODUCT) {
                    cartProduct.setQuantity(quantity);
                    cartProduct.getTotalPrice();
                    this.getTotalPrice();
                    return true;
                }
            } else return false;
        }
        return false;
    }

    public boolean updateProductByPrice(String productCode, int width, int height) {
        StringTokenizer tokenizer = new StringTokenizer(productCode, "_");
        String oldWidth = tokenizer.nextToken();
        String oldHeight = tokenizer.nextToken();
        if (products.containsKey(productCode)) {
            CartProduct existingProduct = products.get(productCode);
            products.remove(productCode);

            String newProductCode = generateProductCode(existingProduct.getId(), width, height);
            if (products.containsKey(newProductCode)) {
                CartProduct newProduct = products.get(newProductCode);
                newProduct.setQuantity(newProduct.getQuantity() + existingProduct.getQuantity());
            } else {
                existingProduct.updateBySize(width, height);
                products.put(newProductCode, existingProduct);
            }
            this.getTotalPrice();
            return true;
        }
        return false;
    }

    public String generateProductCode(int productId, int width, int height) {
        return productId + "_" + width + "_" + height;
    }

    public double getSale() {
        return this.discount.getValue();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartProduct cartProduct : products.values()) {
            totalPrice += cartProduct.getTotalPrice();
        }
//        totalPrice-= getSale()*totalPrice;
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean removeProduct(String productCode) {
        if (products.containsKey(productCode)) {
            products.remove(productCode);
            this.totalPrice= getTotalPrice();
            return true;
        }
        else return false;
    }


    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Map<String, CartProduct> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
