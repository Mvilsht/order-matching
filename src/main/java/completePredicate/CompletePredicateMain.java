package completePredicate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CompletePredicateMain {

    public static void main(String[] args) throws IOException {

        List<Order> orders = new ArrayList<>();
        Order order = JacksonMapper.readValue(new File(""+"src/main/resources/order.json"), Order.class);
        orders.add(order);
        //JsonNode orderRootNode = JacksonMapper.readTree(new File(""+"src/main/resources/order.json"));

        CompletePredicateMain driver = new CompletePredicateMain();

        //driver.run(order, QueryFactory.createQueries());
        driver.run(orders, QueryFactory.createQueries());

    }

    //private void run(Order order, List<Query> queries) throws IOException {
    private void run(List<Order> orders, List<Query> queries) throws IOException {

        for (Query q : queries) {
            System.out.println("---------");
            System.out.println(q);
            System.out.println("q.value.class: " + q.getQValue().getClass());

            BiPredicate genericCondition = OrderPredicates.createCondition(queries.get(0).getQAction());

            System.out.println("----  RESULT  -----");
            System.out.format("%s is %sMatched when ran on %s \n", q, genericCondition.test(orders.get(0), q.getQValue()) ? "" : "NOT ", orders.get(0));

        }


        BiPredicate<Order,String> condition = OrderPredicates.emailContains();
        condition.test(orders.get(0),"email");


        //getIsMatch(orders, OrderPredicates.doublePredicate("mail.com",4003.2));
        getIsMatch(orders, OrderPredicates.greaterThenTotalPricePredicate(400.2));
        getIsMatch(orders, OrderPredicates.containsEmailPredicate("SEAN"));

        System.out.println("DONE");
    }


    private static void getIsMatch(List<Order> orders, Predicate<Order> orderPredicate){
        for (Order order : orders){
            if (orderPredicate.test(order)){
                System.out.println("YEASH MATCH");
            }else {
                System.out.println("NETU MATCH");
            }
        }
    }

}
