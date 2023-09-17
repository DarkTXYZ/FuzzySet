package com.ci.FuzzySet;

public class FuzzyOperator {

    public static <T> FuzzySet<T> union(FuzzySet<T> a, FuzzySet<T> b) {
        if(a.isDomainEqual(b)) {
            FuzzySet<T> result = new FuzzySet<>(a.getDomain());
            return result;
        } else {
            return null;
        }
    }

}
