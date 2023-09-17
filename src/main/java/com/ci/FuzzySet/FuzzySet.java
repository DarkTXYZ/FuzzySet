package com.ci.FuzzySet;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class FuzzySet<T> {

    private final List<Double> membership;
    private final List<T> domain;

    public FuzzySet(List<T> domain, List<Double> membership) {
        this.membership = membership;
        this.domain = domain;
    }

    public FuzzySet(List<T> domain) {
        this.domain = domain;
        this.membership = new ArrayList<>(Collections.nCopies(domain.size(), 0.0));
    }

    public boolean isDomainEqual(FuzzySet<T> r) {
        return domain.equals(r.getDomain());
    }

}
