package compelete;

public interface QueryableI<T> {

     String getQParamName();

     T getQValue();

     QACTION getQAction();

}
