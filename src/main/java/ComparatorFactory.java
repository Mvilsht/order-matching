import java.util.Comparator;

public class ComparatorFactory {

    //actions are from query perspective - i.e QACTION.GT checks if b(from query) > a(from order)
//    private final static Comparator<String> containedComparator = (String a, String b) -> a.contains(b) ? 0 : 1;
//    private final static Comparator<String> greaterThenComparator = (String a, String b) -> (Double.parseDouble(a) < Double.parseDouble(b)) ? 0 : 1;

    public static Comparator<String> createComparator(QACTION qAction){

        switch (qAction){
            case CONTAINS:
                return new ContainedComparator();
                //return containedComparator;
                //return (Comparator<String>) (String a, String b) -> a.contains(b) ? 0 : 1;
            case GT:
                return new GreaterThenComparator();
                //return greaterThenComparator;
            default:
                throw new RuntimeException("No Support for Query Comparator with action: " + qAction);
        }
    }

    private static class ContainedComparator implements Comparator<String>
    {
        // a - Order param, b - Query param
        public int compare(String a, String b)
        {
            if (a.isEmpty() || b.isEmpty())
                return -1;

            return a.contains(b) ? 0 : 1 ; // 0 means compare return equals(true) - a.contains(b)
        }
    }

    private static class GreaterThenComparator implements Comparator<String>
    {
        // a - Order param, b - Query param
        public int compare(String a, String b)
        {
            if (a.isEmpty() || b.isEmpty())
                return -1;

            return (Double.parseDouble(a) < Double.parseDouble(b)) ? 0 : 1; // 0 means compare return equals(true) - a < b
        }
    }
}
