package com.ci.FuzzySet;

import java.util.HashSet;
import java.util.Set;

public class FuzzyOperator {
    public interface BinaryOperator {
        Double compute(Double a, Double b);
    }

    public static class UnionOperator implements BinaryOperator {
        public Double compute(Double a, Double b) {
            return Math.max(a, b);
        }
    }

    public static class IntersectOperator implements BinaryOperator {
        public Double compute(Double a, Double b) {
            return Math.min(a, b);
        }
    }

    public static <T> FuzzySet<T> union(FuzzySet<T> a, FuzzySet<T> b)
        throws Exception {
        return calculate(a, b, new UnionOperator());
    }

    public static <T> FuzzySet<T> intersect(FuzzySet<T> a, FuzzySet<T> b)
        throws Exception {
        return calculate(a, b, new IntersectOperator());
    }

    public static <T> FuzzySet<T> calculate(FuzzySet<T> a, FuzzySet<T> b, BinaryOperator operator)
        throws Exception {
        Set<T> unionDomain = new HashSet<>(a.getDomain());
        unionDomain.addAll(b.getDomain());

        FuzzySet<T> result = new FuzzySet<>(unionDomain);

        for (T domain : result.getDomain()) {
            Double membershipA = a.getMembershipValue(domain);
            Double membershipB = b.getMembershipValue(domain);
            result.getMembership().put(domain, operator.compute(membershipA, membershipB));
        }

        return result;
    }

}
