package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums;

public enum ProductType {
    HANDMADE_PAINTING(0), CROSS_PAINTING(1), COMPUTER_PAINTING(2);

    private final int value;

    ProductType(int i) {
        this.value = i;
    }

    public static ProductType getTypeByValue(int value) {
        for (ProductType type : ProductType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
