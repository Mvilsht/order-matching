package completePredicate;

import java.util.ArrayList;
import java.util.List;

public class QueryFactory {

    public static List<Query> createQueries() {

        List<Query> queries = new ArrayList<>();

        Query q1 = QueryBuilder.createQuery().withAction(QACTION.STRING_CONTAINS).withParamName("email").withValue("@gmail.com").build();
        queries.add(q1);
        Query q2 = QueryBuilder.createQuery().withAction(QACTION.STRING_CONTAINS).withParamName("email").withValue("@walla").build();
        queries.add(q2);
        Query q3 = QueryBuilder.createQuery().withAction(QACTION.GREATER_THEN).withParamName("total_price").withValue(204).build();
        queries.add(q3);
        Query q4 = QueryBuilder.createQuery().withAction(QACTION.GREATER_THEN).withParamName("total_price").withValue(39).build();
        queries.add(q4);
        Query q5 = QueryBuilder.createQuery().withAction(QACTION.OBJ_EQUALS).withParamName("obj1").withValue(new OBJ2("mv", "vil")).build();
        queries.add(q5);
//        Query q6 = QueryBuilder.createQuery().withAction(QACTION.OBJ_EQUALS).withParamName("total_price").withValue(39).build();
//        queries.add(q6);

        return queries;
    }
}
