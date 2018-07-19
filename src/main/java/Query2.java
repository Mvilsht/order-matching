public class Query2 implements QueryPlan2I{

    private final String param;
    private final String pattern;
    private final QACTION action;

    public static class Builder {

        private String qParamName;
        private String qPattern;
        private final QACTION qAction;

        public Builder(QACTION qAction) {
            this.qAction = qAction;
        }

        public Builder setParam(String paramName) {
            qParamName = paramName;
            return this;
        }

        public Builder setPattern(String pattern) {
            qPattern = pattern;
            return this;
        }

        public Query2 build() {
            return new Query2(this);
        }
    }

    // private constructor
    private Query2(Builder builder) {
        // Required parameters
        action = builder.qAction;

        // Optional parameters
        pattern = builder.qPattern;
        param = builder.qParamName;
    }


    public String getQParamName() {
        return param;
    }

    public String getQPattern() {
        return pattern;
    }

    public QACTION getQAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Query2{" +
                "param='" + param + '\'' +
                ", pattern='" + pattern + '\'' +
                ", action=" + action +
                '}';
    }

}
