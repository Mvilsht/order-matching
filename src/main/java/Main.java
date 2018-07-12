public class Main {

    public static String orderStringJson = "{\n" +
            "  \"total_price\": \"193.5\",\n" +
            "  \"email\": \"SEAN@gmail.com\"\n" +
            "}";

    public static void main(String[] args) throws Exception {

        final MapperI myJacksonMAPPER = new JacksonMapper();
        Order order = myJacksonMAPPER.readValue(orderStringJson , Order.class);

        Query query = new Query();

        int run = new ApiRunner(order, query).run();


        System.exit(run);
}

}
