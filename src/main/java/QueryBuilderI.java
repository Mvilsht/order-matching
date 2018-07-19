public interface QueryBuilderI {
    //Interface for building Query's , reflects the process the Engineer would use to build the Query
    //should be able to handle all the possible building components, concrete implementors decide about the rest and returning

     void buildQuery();

     void setQueryParamName();

     void setQueryValue();

     void setQueryAction();

}
