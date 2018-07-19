import java.util.Arrays;
import java.util.List;

public class CompositeQueryBuilder implements QueryBuilderI{

    //concrete builder should be able to build all of its parts and to return it, QueryBuilderI used by the Engineer
    //don't have to implement all the actions - and can leave them blank as default
    private Query<String> query1;
    private Query<Double> query2;

    public CompositeQueryBuilder(){ }

    @Override
    public void buildQuery() {
        query1 = new Query<>();
        query2 = new Query<>();
    }

    @Override
    public void setQueryParamName() {
        query1.setQParamName("email");
        query2.setQParamName("total_price");
    }

    @Override
    public void setQueryValue() {
        query1.setQValue("@gmail.com");
        query2.setQValue(203.0);
    }

    @Override
    public void setQueryAction() {
        query1.setQAction(QACTION.STRING_CONTAINS);
        query2.setQAction(QACTION.GREATER_THEN);
    }

    //returns the Query to the client only via concrete builder
    List<QueryableI> getCompositeQuery() {
        ///return Arrays.asList(query1, query2);
        return Arrays.asList(query1, query2);
    }
}
