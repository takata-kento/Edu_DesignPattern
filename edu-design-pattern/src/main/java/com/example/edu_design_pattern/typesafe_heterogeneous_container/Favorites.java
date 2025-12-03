package com.example.edu_design_pattern.typesafe_heterogeneous_container;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), Objects.requireNonNull(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    @Override
    public String toString() {
        return favorites.toString();
    }
}
