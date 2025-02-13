package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        products.removeIf(product -> {
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                return true;
            }
            return false;
        });
        return removedProducts;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        double total = 0.0;
        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Итого: " + total + " руб.");
    }
}


