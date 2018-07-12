public class Query implements QueryPlanI{

    private String qParamName;
    private String qPattern;
    private String qAction;

//    public Query(String qParamName, String qPattern, String qAction) {
//        this.qParamName = qParamName;
//        this.qPattern = qPattern;
//        this.qAction = qAction;
//    }

    public void setQParamName(String qParamName) {
        this.qParamName = qParamName;
    }

    public void setQPattern(String qPattern) {
        this.qPattern = qPattern;
    }

    public void setQAction(String qAction) {
        this.qAction = qAction;
    }

    public String getQParamName() {
        return qParamName;
    }

    public String getqPattern() {
        return qPattern;
    }

    public String getqAction() {
        return qAction;
    }

    @Override
    public String toString() {
        return "Query{" +
                "qParamName='" + qParamName + '\'' +
                ", qPattern='" + qPattern + '\'' +
                ", qAction='" + qAction + '\'' +
                '}';
    }
}
