package org.skypro.skyshop.Article;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
        size = 0;
    }

    // Метод для добавления объекта в поисковый движок
    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Поисковый движок переполнен!");
        }
    }

    // Метод для поиска
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        query = query.toLowerCase(); // Приводим запрос к нижнему регистру

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[count] = searchable;
                count++;
                if (count == 5) {
                    break; // Прерываем поиск после нахождения 5 результатов
                }
            }
        }

        return results;
    }
}
