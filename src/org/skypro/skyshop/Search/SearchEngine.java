package org.skypro.skyshop.Search;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // TreeMap для автоматической сортировки по ключам
        query = query.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.put(searchable.getName(), searchable);
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

