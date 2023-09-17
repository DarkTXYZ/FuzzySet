package com.ci.FuzzySet;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class FuzzySet<T> {

    private final Map<T, Double> membership;

    public FuzzySet(Map<T, Double> membership) {
        this.membership = membership;
    }

    public FuzzySet(Set<T> domain) {
        this.membership = new HashMap<>();
        for(T d : domain) {
            membership.put(d, 0.0);
        }
    }

    public Set<T> getDomain() {
        return membership.keySet();
    }

    public Double getMembershipValue(T X){
        return this.membership.get(X) == null ? 0.0 : this.membership.get(X);
    }

}
