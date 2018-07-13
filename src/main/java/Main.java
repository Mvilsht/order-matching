import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static String orderStringJson = "{\n" +
//            "  \"total_price\": \"193.5\",\n" +
//            "  \"email\": \"SEAN@gmail.com\"\n" +
//            "}";

    public static void main(String[] args) throws Exception {

        //todo try this way!! test which is more flexible
        Query2 query2 = new Query2.Builder(QACTION.CONTAINS).setParam("email").setPattern("@gmail.com").build();
        System.out.println(query2);

        Query2 query3 = new Query2.Builder(QACTION.GT).setParam("total_price").setPattern("193.4").build();
        System.out.println(query3);

        List<Query2> query2List = new ArrayList<>();

        query2List.add(query2);
        query2List.add(query3);


//        QueryBuilderI queryBuilder = new ContainQueryBuilder();
//        QueryEngineer queryEngineer = new QueryEngineer(queryBuilder);
//        queryEngineer.makeQuery();
//        Query query1 = queryEngineer.getQuery();
//        System.out.println(query1);

        Order order = new JacksonMapper().readValue(Paths.get(""+"src/main/resources/order.json").toFile() , Order.class);

        for(Query2 q : query2List){
            System.out.format("%s is %sMatched when ran on %s \n", q, order.performActionIsMatch(q) ? "" : "NOT ", order);
        }

        //Order order = myJacksonMAPPER.readValue(orderStringJson, Order.class);

//        System.out.format("%s is %s Matched when ran on %s \n", query1, order.performActionIsMatch(query1) ? "" : "NOT", order);
//        System.out.format("%s is %sMatched when ran on %s \n", query2, order.performActionIsMatch(query2) ? "" : "NOT ", order);
//        System.out.format("%s is %sMatched when ran on %s \n", query3, order.performActionIsMatch(query3) ? "" : "NOT ", order);

}

}
