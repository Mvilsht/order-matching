import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static String orderStringJson = "{\n" +
//            "  \"total_price\": \"193.5\",\n" +
//            "  \"email\": \"SEAN@gmail.com\"\n" +
//            "}";

    public static void main(String[] args) throws Exception {

        Query2 query2 = new Query2.Builder(QACTION.STRING_CONTAINS).setParam("email").setPattern("@gmail.com").build();
        System.out.println(query2);




        Query2 query3 = new Query2.Builder(QACTION.GREATER_THEN).setParam("total_price").setPattern("193.4").build();
        System.out.println(query3);

        List<Query2> query2List = new ArrayList<>();
        query2List.add(query2);
        query2List.add(query3);


        Order order = new JacksonMapper().readValue(Paths.get(""+"src/main/resources/order.json").toFile() , Order.class);
        System.out.println(order);



        QueryBuilder queryBuilder = new QueryBuilder();
        CompositeQueryBuilder compositeQueryBuilder = new CompositeQueryBuilder();
        HasParamQueryBuilder paramExistQueryBuilder = new HasParamQueryBuilder();


        queryBuilder.buildQuery();

        new QueryEngineer(queryBuilder).constructQuery();
        new QueryEngineer(compositeQueryBuilder).constructQuery();
        new QueryEngineer(paramExistQueryBuilder).constructQuery();


        Query query = queryBuilder.getQuery();
        System.out.println("-------- query -------");
        System.out.println("query: " + query);
        System.out.println("query.getClass(): " + query.getClass());

        List<QueryableI> compositeQuery = compositeQueryBuilder.getCompositeQuery();
        System.out.println("-------- compositeQuery -------");
        compositeQuery.forEach(System.out::println);

        ParamQuery paramQuery = paramExistQueryBuilder.getParamQuery();
        System.out.println("-------- paramQuery -------");
        System.out.println("paramQuery: " + paramQuery);
        System.out.println("paramQuery.getClass(): " + paramQuery.getClass());

        System.out.println("-------- Results -------");
        System.out.format("%s is %sMatched when ran on %s \n", query, order.isQueryMatch(query) ? "" : "NOT ", order);

        System.out.format("%s is %sMatched when ran on %s \n", compositeQuery, order.isCompositeQueryMatch(compositeQuery) ? "" : "NOT ", order);

        System.out.format("%s is %sMatched when ran on %s \n", paramQuery, order.isQueryMatch(paramQuery) ? "" : "NOT ", order);

    }
}
