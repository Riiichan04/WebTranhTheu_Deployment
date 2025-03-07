package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.DiscountDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.DiscountDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

public class DiscountService {
    private static DiscountDAO discountDAO;
    public DiscountService() {
        discountDAO = JDBIConnector.getInstance().onDemand(DiscountDAO.class);
    }

    public List<DiscountDTO> getAllDiscountDTO() {
        return discountDAO.getAllDiscountDTO();
    }

    public int addDiscount(Discount discount) {
        return discountDAO.insertDiscount(discount);
    }

    public void addDiscountProduct(String[] selectedDiscountProduct, int discountId) {
        for(String productId : selectedDiscountProduct) {
            discountDAO.insertDiscountProduct(discountId, Integer.parseInt(productId));
        }
    }

    public void deleteDiscountProduct(String[] selectedDiscountProduct, int discountId) {
        for(String productId : selectedDiscountProduct) {
            discountDAO.deleteDiscountProduct(Integer.parseInt(productId), discountId);
        }
    }

    public List<Product> listDiscountProduct(int discountId) {
        return discountDAO.listDiscountProduct(discountId);
    }

    public List<Product> listNotInDiscount(int discountId) {
        return discountDAO.getProductNotInDiscount(discountId);
    }

    public Discount getDiscount(int id) {
        return discountDAO.getDiscountById(id);
    }

    public void updateDiscount(Discount discount) {
        discountDAO.updateDiscount(discount);
    }

    public List<Discount> getDiscountValid() {
        return discountDAO.getDiscountValid();
    }

    public List<Discount> getListDiscountAvailable(){return discountDAO.getDiscountAvailable();}

    public static String displayDiscount(Discount discount) {
        if (discount == null || discount.getTitle() == null) return "Hiện tại chưa có chương trình giảm giá nào.";
        else return discount.getDescription();
    }
}
