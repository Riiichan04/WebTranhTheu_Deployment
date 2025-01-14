package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Product implements Serializable {
    private int id; //Id của sản phẩm
    private String code;    //Mã của sản phẩm
    private String title;   //Tên sản phẩm
    private String description; //Mô tả sản phẩm
    private Category category;    //Loại danh mục của sản phẩm
    private Provider provider;  //Thông tin nhà cung cấp
    private Policy policy;  //Thông tin chính sách áp dụng cho sản phẩm
    private List<Material> listMaterials;   //Thông tin nguyên liệu của sản phẩm
    private List<Review> listReviews;   //Danh sách review của sản phảm
    private List<Price> listPrices; //Danh sách giá tiền của sản phẩm
    private List<String> listImageUrls; //Danh sách hình ảnh của sản phẩm
    private List<Discount> listDiscounts; //Danh sách chuương trình giảm giá của sản phẩm
    private int type; //Cho biết đây là tranh hay nguyên liệu
    private Timestamp createdAt; // ngày tạo sản phẩm
    private Timestamp updatedAt; //ngày cập nhật sản phẩm

    public Product() {
        this.listMaterials = new ArrayList<>();
        this.listReviews = new ArrayList<>();
        this.listDiscounts = new ArrayList<>();
        this.listPrices = new ArrayList<>();
        this.listImageUrls = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public List<Material> getListMaterials() {
        return listMaterials;
    }

    public void setListMaterials(List<Material> materials) {
        this.listMaterials = materials;
    }

    public List<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<Review> listReviews) {
        this.listReviews = listReviews;
    }

    public List<Price> getListPrices() {
        return listPrices;
    }

    public void setListPrices(List<Price> listPrices) {
        this.listPrices = listPrices;
    }

    public List<String> getListImageUrls() {
        return listImageUrls;
    }

    public void setListImageUrls(List<String> listImageUrls) {
        this.listImageUrls = listImageUrls;
    }

    public List<Discount> getListDiscounts() {
        return listDiscounts;
    }

    public void setListDiscounts(List<Discount> listDiscounts) {
        this.listDiscounts = listDiscounts;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Price getMinPrice() {
        return listPrices.stream().min(Comparator.comparingDouble(Price::getPrice)).orElse(null);
    }

    public Price getSelectedPrice(int width, int height) {
        for (int i = 0; i < this.listPrices.size(); i++) {
            Price price = this.getListPrices().get(i);
            if (price.getWidth() == width && price.getHeight() == height) return price;
        }
        return null;
    }
    public String getThumbnail() {
        //Mặc định lấy hình đầu tiên
        return this.listImageUrls.get(0);
    }
    public Discount maxDiscount() {
        // lấy discount có giá trị lớn nhất
        return listDiscounts.stream().max(Comparator.comparingDouble(Discount::getAmount)).orElse(null);
    }
    public Discount getSelectedDiscount(){
        // lấy discount người dùng chọn
        return null;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

