package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class ConcreateProductDAO implements ProductDAO {
    //Dùng để hiển thị thông tin product dưới dạng card
    @Override
    public Product getProductInfo(int productId) {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("""
                                select products.title, products.code, products.description, products.typeOfProduct
                                from products
                                join category_product_details
                                    on products.id = category_product_details.productId
                                where products.id = :id
                                """)
                        .bind("id", productId).map((rs, ctx) -> {
                            Product product = new Product();
                            product.setId(productId);
                            product.setCode(rs.getString("code"));
                            product.setTitle(rs.getString("title"));
                            product.setDescription(rs.getString("description"));
                            product.setType(rs.getInt("typeOfProduct"));
                            return product;
                        }).one()
        );
    }

}
