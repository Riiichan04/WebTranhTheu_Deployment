package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface ProductDAO {
    Product getProductInfo(int productId);

    //Chọn cách nào để làm ???
    interface ProductQueries {
        @SqlQuery("select products.title, products.code, products.description, products.typeOfProduct from products join category_product_details on products.id = category_product_details.productId join product_images on product_images.productId = products.id where products.id = :id")
        Product getProductBasicInfo(@Bind("id") int id);    //Có thể bỏ vì Map cái này khó

        @SqlQuery("select providers.* from providers join products on providers.id = products.providerId where products.id = :id")
        Provider getProductProvider(@Bind("id") int id);
    }
}
