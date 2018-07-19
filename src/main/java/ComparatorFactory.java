import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorFactory {

    //actions are from query perspective - i.e QACTION.GREATER_THEN checks if b(from query) > a(from order)
//    private final static Comparator<String> containedComparator = (String a, String b) -> a.contains(b) ? 0 : 1;
//    private final static Comparator<String> greaterThenComparator = (String a, String b) -> (Double.parseDouble(a) < Double.parseDouble(b)) ? 0 : 1;

    public static Comparator createComparator(QACTION qAction){

        switch (qAction){
            case STRING_CONTAINS:
                return new ContainsComparator();
            case GREATER_THEN:
                return new GreaterThenComparator();
            case OBJ_EQUALS:
                return new ObjectEqualsComparator();
            case HAS_PARAM:
                return new HasParamComparator();
            default:
                throw new RuntimeException("No Support for Query Comparator with action: " + qAction);
        }
    }

    private static class HasParamComparator <T> implements Comparator<T>
    {
        // a - Order param, b - Query param
        public int compare(T a, T b)
        {
            return (a == Collections.EMPTY_LIST) ? 1 : 0; // true if a order have param value, meaning value for param was found
        }
    }


    private static class ObjectEqualsComparator <T> implements Comparator<T>
    {
        // a - Order param, b - Query param
        public int compare(T a, T b)
        {
            return a.equals(b) ? 0 : 1;
        }
    }

    private static class ContainsComparator <T extends String> implements Comparator<T>
    {
        // a - Order param, b - Query param
        public int compare(T a, T b)
        {
            return a.contains(b) ? 0 : 1 ; // 0 means compare return equals(true) - a.contains(b)
        }
    }

    private static class GreaterThenComparator <T extends Number & Comparable> implements Comparator<T>
    {
        // a - Order param, b - Query param
        public int compare(T a, T b)
        {
            BigDecimal n1c = new BigDecimal(a.toString());
            BigDecimal n2c = new BigDecimal(b.toString());

            return n1c.compareTo(n2c) < 0 ? 0 : 1 ;
            //return (a.compareTo(b) < 0) ? 0 : 1; // 0 means compare return equals(true) - a < b
        }

    }
}
