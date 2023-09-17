package com.ci.FuzzySet;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> domain = Arrays.asList("A","B","C");
        List<Double> membership = Arrays.asList(0.1,0.2,0.3);
        List<Double> membership2 = Arrays.asList(1.0,0.8,0.5);

        FuzzySet<String> fuzzySet = new FuzzySet<>(domain, membership);
        FuzzySet<String> fuzzySet2 = new FuzzySet<>(domain, membership2);

        System.out.println(FuzzyOperator.union(fuzzySet,fuzzySet2));

    }
}
