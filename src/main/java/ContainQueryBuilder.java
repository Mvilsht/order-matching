public class ContainQueryBuilder implements QueryBuilderI{

    Query query;

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
        query.setQAction("Contains");   // TODO here type specific comparator?
    }

    @Override
    public Query getQuery() {
        return query;
    }
}
