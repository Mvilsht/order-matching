package compelete;

import java.math.BigDecimal;
import java.util.Comparator;

public class ComparatorFactory {

    public static Comparator createOrderComparator(String paramName, QACTION action) {

        switch (paramName){
            case "email":
                return newEmailComparator(action);
            case "total_price":
                return newTotalPriceComparator(action);
            case "obj1":
                return newOBJ1Comparator(action);
            default:
                throw new RuntimeException("No Support for orderComparator with action: " + paramName);
        }

    }

    private static Comparator newEmailComparator(QACTION action) {
        switch (action){
            case STRING_CONTAINS:
                return new ContainsComparator();
            case OBJ_EQUALS:
                return new ObjectEqualsComparator();
            default:
                throw new RuntimeException("No Support for orderEmailComparator for action: " + action);
        }
    }

    private static Comparator newTotalPriceComparator(QACTION action) {
        switch (action){
            case GREATER_THEN:
                return new GreaterThenComparator();
            case OBJ_EQUALS:
                return new ObjectEqualsComparator();
            default:
                throw new RuntimeException("No Support for orderTotalPriceComparator for action: " + action);
        }
    }

    private static Comparator newOBJ1Comparator(QACTION action) {
        switch (action){
            case OBJ_EQUALS:
                return new ObjectEqualsComparator();
            default:
                throw new RuntimeException("No Support for orderOBJ1Comparator for action: " + action);
        }
    }

    private static class GreaterThenComparator <T extends Number & Comparable> implements Comparator<T> {
        public int compare(T a, T b) {
            BigDecimal n1c = new BigDecimal(a.toString());
            BigDecimal n2c = new BigDecimal(b.toString());
            return n1c.compareTo(n2c) < 0 ? 0 : 1 ; // 0 means compare return equals(true) - a < b
        }
    }

    private static class ContainsComparator <T extends String> implements Comparator<T> {
        public int compare(T a, T b)
        {
            return a.contains(b) ? 0 : 1 ; // 0 means compare return equals(true) - a.contains(b)
        }
    }

    private static class ObjectEqualsComparator <T> implements Comparator<T> {
        public int compare(T a, T b)
        {
            return a.equals(b) ? 0 : 1;
        }
    }

}