
public class ParamQuery <T> implements QueryableI<T>, QueryPlanI<T>{
//this is the product we are building

    private String qParamName;
    private QACTION qAction;
    private T qValue;

    @Override
    public void setQParamName(String qParamName) {
        this.qParamName = qParamName;
    }

    @Override
    public void setQValue(T qValue) {
        this.qValue = qValue;
    }

    @Override
    public void setQAction(QACTION qAction) {
        this.qAction = qAction;
    }


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

    @Override
    public String toString() {
        return "ParamQuery{" +
                "qParamName='" + qParamName + '\'' +
                ", qAction=" + qAction +
                '}';
    }
}

