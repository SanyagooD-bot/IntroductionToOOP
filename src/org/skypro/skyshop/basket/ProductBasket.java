package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        return productsMap.remove(name);
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        // Вывод всех продуктов
        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        // Вывод общей стоимости
        double total = getTotalPrice();
        System.out.println("Итого: " + total + " руб.");

        // Вывод количества специальных товаров
        int specialCount = getSpecialCount();
        System.out.println("Специальных товаров: " + specialCount);
    }

    private double getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private int getSpecialCount() {
        return (int) productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
}


