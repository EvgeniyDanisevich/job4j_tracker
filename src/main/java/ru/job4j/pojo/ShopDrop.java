package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index == products.length - 1) {
            products[index] = null;
        } else {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }
}