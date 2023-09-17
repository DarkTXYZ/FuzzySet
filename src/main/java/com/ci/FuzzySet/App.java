package com.ci.FuzzySet;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String[] domain = new String[]{"A", "B", "C"};
        String[] domain2 = new String[]{"A", "B","D"};
        Double[] membershipValue = new Double[]{0.1, 0.5, 0.3};
        Double[] membershipValue2 = new Double[]{0.9, 0.4, 1.0};

        Map<String,Double> membership = new HashMap<>();
        for (int i = 0; i < domain.length; i++) {
            membership.put(domain[i], membershipValue[i]);
        }

        Map<String,Double> membership2 = new HashMap<>();
        for (int i = 0; i < domain2.length; i++) {
            membership2.put(domain2[i], membershipValue2[i]);
        }

        FuzzySet<String> fuzzySet = new FuzzySet<>(membership);
        FuzzySet<String> fuzzySet2 = new FuzzySet<>(membership2);

        System.out.println(FuzzyOperator.union(fuzzySet,fuzzySet2));
        System.out.println(FuzzyOperator.intersect(fuzzySet,fuzzySet2));
//        System.out.println(fuzzySet.equals(fuzzySet2));

    }
}
