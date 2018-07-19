
public interface QueryPlanI<T> {

     void setQParamName(String fieldName);

     void setQValue(T qValue);

     void setQAction(QACTION qAction);

//     String getQParamName();
//
//     String getQValue();
//
//     QACTION getQAction();

}
