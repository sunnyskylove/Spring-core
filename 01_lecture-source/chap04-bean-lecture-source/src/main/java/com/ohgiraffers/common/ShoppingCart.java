package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();  // item 생성시켜줄 것임~~
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItem() {
        return items;    // 장바구니에 어떤 물건들이 있는지 확인해 볼 것!
    }

}