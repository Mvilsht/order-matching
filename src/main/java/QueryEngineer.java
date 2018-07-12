public class QueryEngineer {

    QueryBuilderI queryBuilder;

    public QueryEngineer(QueryBuilderI queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    public Query getQuery(){
        return queryBuilder.getQuery();
    }

    // Execute the methods specific to the QueryBuilder
    // that implements QueryBuilder (ContainQueryBuilder)

    public void makeQuery(){
        queryBuilder.buildQueryParamName();
        queryBuilder.buildQueryPattern();
        queryBuilder.buildQueryAction();
    }


}
