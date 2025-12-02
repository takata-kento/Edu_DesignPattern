package com.example.edu_design_pattern.builder;

import java.util.Objects;

public class RiskUser extends User {
    public enum RiskCategory { SMOKING, DRINKING, DRUG }
    private final RiskCategory riskCategory;
    public static class Builder extends User.Builder<Builder> {
        private final RiskCategory riskCategory;

        public Builder(RiskCategory riskCategory) {
            this.riskCategory = Objects.requireNonNull(riskCategory);
        }

        @Override
        public RiskUser build() {
            return new RiskUser(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private RiskUser(Builder builder) {
        super(builder);
        riskCategory = builder.riskCategory;
    }

    @Override
    public String toString() {
        return "cources: " + this.cources.toString() + " riskCategory: " + this.riskCategory.toString();
    }
}
