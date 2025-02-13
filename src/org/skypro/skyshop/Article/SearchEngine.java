package org.skypro.skyshop.Article;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
        size = 0;
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Поисковый движок переполнен!");
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        search = search.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String term = searchable.getSearchTerm();
                int count = countOccurrences(term, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String term, String search) {
        int count = 0;
        int index = term.indexOf(search);
        while (index != -1) {
            count++;
            index = term.indexOf(search, index + 1);
        }
        return count;
    }
}