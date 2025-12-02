package com.example.edu_design_pattern.builder;

public class StandardUser extends User {
    public static class Builder extends User.Builder<Builder> {
        @Override
        public StandardUser build() {
            return new StandardUser(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private StandardUser(Builder builder) {
        super(builder);
    }

    @Override
    public String toString() {
        return "cources: " + this.cources.toString();
    }
}
