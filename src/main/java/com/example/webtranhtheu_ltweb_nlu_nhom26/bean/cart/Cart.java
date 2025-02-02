package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    private Map<String, CartProduct> products; // key là Code của Product, Value là 1 CartProduct
    public static final int MAX_CART_PRODUCTS = 10;
    private static Cart instance;
    private List<Discount> discountList;
    private Discount discount; // 1 giỏ hàng chỉ áp dụng 1 cart, lưu lại discount đã chọn
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
            CartProduct cartProduct = covertToCart(product, price);
            cartProduct.setQuantity(quantity);
            if (productCode.equals("no price")) {
                return false;
            }
            cartProduct.updateBySize(price.getWidth(), price.getHeight());
            cartProduct.setPrice(price);
            cartProduct.setTotalPrice(cartProduct.getTotalPrice());
            products.put(productCode, cartProduct);
            return true;
        }
    }


    private CartProduct covertToCart(Product product, Price price) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(product.getId());
        cartProduct.setTitle(product.getTitle());
        cartProduct.setThumbnailUrl(product.getThumbnail());
        cartProduct.setPrices(product.getListPrices());
        cartProduct.setPrice(price);
        cartProduct.setTotalPrice(cartProduct.getTotalPrice());
        return cartProduct;
    }

    public boolean updateProductByQuantity(String productCode, int quantity) {
        CartProduct cartProduct = products.get(productCode);
        if (cartProduct != null) {
            if (cartProduct.getPrice().getAvailable() > quantity) {
                if (quantity > 0 && quantity <= CartProduct.MAX_PER_PRODUCT && getCartSize() + (quantity-cartProduct.getQuantity())<=MAX_CART_PRODUCTS) {
                    cartProduct.setQuantity(quantity);
                    cartProduct.getTotalPrice();
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
        return totalPrice;
    }

    public boolean removeProduct(String productCode) {
        if (products.containsKey(productCode)) {
            products.remove(productCode);
            return true;
        } else return false;
    }


    public Discount getMaxDiscount() {
        return this.discountList.stream().max(Comparator.comparingDouble(Discount::getValue)).orElse(null);
    }

    public Discount getSelectedDiscount(int discountId) {
        return this.discountList.get(discountId);
    }



    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
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

    //Nên tách các method utilities như này sang CartService hoặc CartUtil
    public int getCartSize() {
        return this.products.values().stream().mapToInt(CartProduct::getQuantity).sum();
    }

    public int getSize() {
        return products.size();
    }

    public double getTotalPrice(List<String> listCode) {
        double result = 0;
        for (String code : listCode) {
            result += this.products.get(code).getTotalPrice();
        }
        return result;
    }

    public double getFinalPrice(double basePrice, int deliveryPrice, Discount discount) {
        if (discount == null ) return basePrice + deliveryPrice;
        else return basePrice - (basePrice * discount.getValue() + deliveryPrice);
    }

    public String getDisplayPriceToString(double price) {
        return ProductService.getDisplayPriceToString(price);
    }
}
