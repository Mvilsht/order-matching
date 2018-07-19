public class QueryEngineer {
    //Constructs Query objects using the QueryBuilder interface

    private QueryBuilderI queryBuilder;

    public QueryEngineer(QueryBuilderI queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

     void constructQuery(){
        queryBuilder.buildQuery();
        queryBuilder.setQueryParamName();
        queryBuilder.setQueryValue();
        queryBuilder.setQueryAction();

        //return queryBuilder.getQuery();
    }
//
//
//    void constructComplexQuery(){
//        queryBuilder.buildQuery();
//        queryBuilder.setQueryParamName();
//        queryBuilder.setQueryValue();
//        queryBuilder.setQueryAction();
//
//        //return queryBuilder.getQuery();
//    }

    // Execute the methods specific to the QueryBuilder
    // that implements QueryBuilder (QueryBuilder)

//    public void makeQuery(){
//
//    }


}
