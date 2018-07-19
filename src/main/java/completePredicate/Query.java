package completePredicate;


public class Query<T> implements QueryableI<T> {
//this is the product we are building

    private String qParamName;
    private T qValue;
    private QACTION qAction;

    @Override
    public String getQParamName() {
        return qParamName;
    }

    @Override
    public T getQValue() {
        return qValue;
    }

    @Override
    public QACTION getQAction() {
        return qAction;
    }


    public void setqParamName(String qParamName) {
        this.qParamName = qParamName;
    }

    public void setqValue(T qValue) {
        this.qValue = qValue;
    }

    public void setqAction(QACTION qAction) {
        this.qAction = qAction;
    }

    @Override
    public String toString() {
        return "Query{" +
                "qParamName='" + qParamName + '\'' +
                ", qValue=" + qValue +
                ", qAction=" + qAction +
                '}';
    }

}
