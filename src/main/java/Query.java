public class Query implements QueryPlanI{

    private String name;
    private String pattern;
    private String action;

//    public Query(String name, String pattern, String action) {
//        this.name = name;
//        this.pattern = pattern;
//        this.action = action;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getPattern() {
        return pattern;
    }

    public String getAction() {
        return action;
    }
}
