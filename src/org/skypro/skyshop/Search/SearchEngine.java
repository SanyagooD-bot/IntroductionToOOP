package org.skypro.skyshop.Search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>(); // Используем HashSet для хранения уникальных элементов
    }

    public void add(Searchable searchable) {
        searchables.add(searchable); // Добавляем элемент в Set (дубликаты игнорируются)
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator()); // Используем TreeSet с компаратором
        query = query.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        search = search.toLowerCase();

        for (Searchable searchable : searchables) {
            String term = searchable.getSearchTerm();
            int count = countOccurrences(term, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
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

