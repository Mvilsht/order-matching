public class Main {

    public static String orderStringJson = "{\n" +
            "  \"total_price\": \"193.5\",\n" +
            "  \"email\": \"SEAN@gmail.com\"\n" +
            "}";

    public static void main(String[] args) throws Exception {

        final MapperI myJacksonMAPPER = new JacksonMapper();
        Order order = myJacksonMAPPER.readValue(orderStringJson , Order.class);

        //Query query = new Query();

        // TODO also implement using factory
        QueryBuilderI queryBuilder = new ContainQueryBuilder();
        //int run = new ApiRunner(order, query).run();

        QueryEngineer queryEngineer = new QueryEngineer(queryBuilder);
        queryEngineer.makeQuery();
        Query firstContainsQuery = queryEngineer.getQuery();

        System.out.println("Query BUIDL");

        System.out.println("Query for Param Name: " + firstContainsQuery.getQParamName());
        System.out.println("Query for Pattern Name: " + firstContainsQuery.getqPattern());
        System.out.println("Query for Action Name: " + firstContainsQuery.getqAction());

        order.performAction(firstContainsQuery);

        //get Order according to Order Json
        //use QueryBuilderI to build Query

        //query_action - should be the comparator - telling us how to compareTo(orderFieldName, field_pattern)
        //build query made of: field_name, field_pattern/value, query_action


        //System.exit(run);
}

}
