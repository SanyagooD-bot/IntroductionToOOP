package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printBasket() {
        double total = 0.0;
        int specialCount = 0;

        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + total + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }
}

