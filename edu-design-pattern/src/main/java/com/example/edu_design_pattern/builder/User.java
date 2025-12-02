package com.example.edu_design_pattern.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class User {
    public enum Cource { MEDIUM_MOTORCYCLE, LARGE_MOTORCYCLE, AUTOMOBILE }
    final Set<Cource> cources;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Cource> cources = EnumSet.noneOf(Cource.class);
        public T addCource(Cource cource) {
            cources.add(Objects.requireNonNull(cource));
            return self();
        }
        abstract User build();
        protected abstract T self();
    }

    User(Builder<?> builder) {
        cources = builder.cources.clone();
    }
}
