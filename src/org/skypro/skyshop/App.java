package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
//import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static class Main {
        public static void main(String[] args) {
            // Создаем товары
            Product simpleProduct = new SimpleProduct("Молоко", 80.0);
            Product discountedProduct = new DiscountedProduct("Хлеб", 50.0, 10);
            Product fixPriceProduct = new FixPriceProduct("Сок");

            // Создаем статьи
            Article article1 = new Article("Польза молока", "Молоко полезно для здоровья.");
            Article article2 = new Article("Рецепты с хлебом", "Хлеб можно использовать в различных блюдах.");
            Article article3 = new Article("Соки для детей", "Соки — это вкусно и полезно.");

            // Создаем поисковый движок
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(simpleProduct);
            searchEngine.add(discountedProduct);
            searchEngine.add(fixPriceProduct);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);

            // Демонстрация поиска
            System.out.println("Результаты поиска по запросу 'молоко':");
            Searchable[] results = searchEngine.search("молоко");
            for (Searchable result : results) {
                if (result != null) {
                    System.out.println(result.getStringRepresentation());
                }
            }

            System.out.println("\nРезультаты поиска по запросу 'хлеб':");
            results = searchEngine.search("хлеб");
            for (Searchable result : results) {
                if (result != null) {
                    System.out.println(result.getStringRepresentation());
                }
            }

            System.out.println("\nРезультаты поиска по запросу 'сок':");
            results = searchEngine.search("сок");
            for (Searchable result : results) {
                if (result != null) {
                    System.out.println(result.getStringRepresentation());
                }
            }
        }
    }
}
