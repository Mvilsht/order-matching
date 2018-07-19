public class QueryBuilder implements QueryBuilderI {

    //concrete builder should be able to build all of its parts and to return it, QueryBuilderI used by the Engineer
    //don't have to implement all the actions - and can leave them blank as default
//    private Query<OBJ1> query;
    private Query<OBJ1> query;

    public QueryBuilder(){ }

    @Override
    public void buildQuery() {
        this.query = new Query<>();
    }

    @Override
    public void setQueryParamName() {
        query.setQParamName("obj1");
    }

    @Override
    public void setQueryValue() {
        query.setQValue(new OBJ1("mv","vil"));
    }

    @Override
    public void setQueryAction() {
        query.setQAction(QACTION.OBJ_EQUALS);
    }

    //returns the Query to the client only via concrete builder
    Query<OBJ1> getQuery() {
        return query;
    }
}
