package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.BestResultNotFound;
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
            try {
                Searchable bestMatch = searchEngine.findBestMatch("молоко");
                System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            try {
                Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
                System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
