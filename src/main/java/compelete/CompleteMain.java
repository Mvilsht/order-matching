package compelete;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class CompleteMain {

    public static void main(String[] args) throws IOException {

        Order order = JacksonMapper.readValue(new File(""+"src/main/resources/order.json"), Order.class);
        JsonNode orderRootNode = JacksonMapper.readTree(new File(""+"src/main/resources/order.json"));

        CompleteMain driver = new CompleteMain();

        //driver.run(order, QueryFactory.createQueries());
        driver.run(orderRootNode, QueryFactory.createQueries());

    }

    //private void run(Order order, List<Query> queries) throws IOException {
    private void run(JsonNode orderJson, List<Query> queries) throws IOException {

        for (Query q : queries) {
            System.out.println("---------");
            System.out.println(q);
            System.out.println("q.value.class: " + q.getQValue().getClass());

            String paramName = q.getQParamName();

            Comparator comparator = ComparatorFactory.createOrderComparator(paramName, q.getQAction());

            String orderParamValueString = orderJson.get(paramName).toString();

            System.out.println("orderParamValueString: " + orderParamValueString);

            System.out.println("----  RESULT  -----");
            //System.out.format("%s is %sMatched when ran on %s \n", queries.get(0), comparator.compare(orderParamValue, queries.get(0).getQValue()) == 0 ? "" : "NOT ", order);
            System.out.format("%s is %sMatched when ran on %s \n", q,
                            comparator.compare(
                            JacksonMapper.readValue(orderParamValueString, q.getQValue().getClass()), q.getQValue()) == 0 ? "" : "NOT ", orderJson);
        }

        System.out.println("DONE");
    }

}
