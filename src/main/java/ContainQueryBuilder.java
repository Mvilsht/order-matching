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
        query.setQAction(QACTION.CONTAINS);
    }

    @Override
    public Query getQuery() {
        return query;
    }
}
