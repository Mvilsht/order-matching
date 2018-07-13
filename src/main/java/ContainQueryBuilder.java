public class ContainQueryBuilder implements QueryBuilderI{

    private final Query query;

    public ContainQueryBuilder(){
        this.query = new Query();
    }

    @Override
    public void buildQueryParamName() {
        query.setQParamName("email");
    }

    @Override
    public void buildQueryPattern() {
        query.setQPattern("@gmail.com");
    }

    @Override
    public void buildQueryAction() {
        //build specific comparator
        query.setQAction(QACTION.CONTAINS);   // TODO here type specific comparator?
    }

    @Override
    public Query getQuery() {
        return query;
    }
}
