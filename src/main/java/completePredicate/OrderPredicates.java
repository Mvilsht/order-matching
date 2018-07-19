package completePredicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class OrderPredicates {


    public static BiPredicate createCondition(QACTION qaction) {

        switch (qaction){
            case STRING_CONTAINS :
                return emailContains();
            case GREATER_THEN :
                return totalPriceGreaterThen();
            case OBJ_EQUALS:
                return objEquels();
            default:
                throw new RuntimeException("No support for this action");
        }
    }

//
//    public static BiPredicate<Order,Query> emailBiPredicate(QACTION qaction) {
//
//        switch (qaction) {
//            case STRING_CONTAINS:
//                return (order, query) ->
//                        order.getEmail().contains(query.getQValue());
//            case GREATER_THEN:
//
//            default:
//                throw new RuntimeException("No support for this action");
//
//        }
//    }

    public static BiPredicate<Order,OBJ2> objEquels() {
        return (order, qData) -> order.getObj().equals(qData);
    }

    public static BiPredicate<Order,String> emailContains() {
        return (order, qData) -> order.getEmail().contains(qData);
    }

    public static BiPredicate<Order,Double> totalPriceGreaterThen() {
        return (order, qData) -> order.getTotalPrice() < qData;
    }


    //
//    public static Predicate<Order> emailOrderPredicate = order -> order.getEmail().equals(Gender.FEMALE);
//
//    public static Predicate<Order> objOrderPredicate = order -> order.getObj().equals(Gender.FEMALE);
    public static Predicate<Order> greaterThenTotalPricePredicate(Double price) {
        return order -> order.getTotalPrice() < price;
    }


    public static Predicate<Order> containsEmailPredicate(String pattern){
        return order -> order.getEmail().contains(pattern);
    }
//
//
//    public class Predicate<Order> doublePredicate(String pattern, Double price){
//        return OrderPredicates.containsEmailPredicate(pattern).and(OrderPredicates.greaterThenTotalPricePredicate(price));
//    }



}
