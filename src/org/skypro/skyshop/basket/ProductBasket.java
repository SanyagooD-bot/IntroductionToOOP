package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        // Получаем список продуктов по имени
        List<Product> products = productsMap.getOrDefault(product.getName(), new ArrayList<>());
        // Добавляем продукт в список
        products.add(product);
        // Обновляем Map
        productsMap.put(product.getName(), products);
    }

    public List<Product> removeProductsByName(String name) {
        // Удаляем список продуктов по имени и возвращаем его
        return productsMap.remove(name);
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        double total = 0.0;
        // Перебираем все значения (списки продуктов) в Map
        for (List<Product> products : productsMap.values()) {
            // Перебираем каждый продукт в списке
            for (Product product : products) {
                System.out.println(product);
                total += product.getPrice();
            }
        }
        System.out.println("Итого: " + total + " руб.");
    }
}


