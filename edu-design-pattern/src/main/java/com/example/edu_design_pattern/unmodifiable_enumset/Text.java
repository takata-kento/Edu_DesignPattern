package com.example.edu_design_pattern.unmodifiable_enumset;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
    private EnumSet<Style> styles;

    public void setStyle(Set<Style> styles) {
        this.styles = styles.stream()
                        .reduce(
                            EnumSet.noneOf(Style.class),
                            (result, style) -> { 
                                result.add(style);
                                return result;
                            },
                            (result1, result2) -> result1
                        );
    }

    public Set<Style> getStyles() {
        // これだとミュータブルになってしまう
        // return styles;

        // EnumSetではなくSet型で結果を返してもよいのであればCollections#unmodifiableSetを使用する
        return Collections.unmodifiableSet(styles);
    }
}
