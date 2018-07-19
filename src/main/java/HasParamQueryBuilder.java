public class HasParamQueryBuilder implements QueryBuilderI {

    //concrete builder should be able to build all of its parts and to return it, used by the Engineer
    //the concrete class is actually does all the work
    private ParamQuery<String> query;

    public HasParamQueryBuilder(){
    }

    @Override
    public void buildQuery() {
        this.query = new ParamQuery<>();
    }

    @Override
    public void setQueryParamName() {
        query.setQParamName("total_price");
    }

    @Override
    public void setQueryValue() {  query.setQValue("NO_VAL");  }

    @Override
    public void setQueryAction() {
        query.setQAction(QACTION.HAS_PARAM);
    }

    public ParamQuery<String> getParamQuery() {
        return query;
    }

}

