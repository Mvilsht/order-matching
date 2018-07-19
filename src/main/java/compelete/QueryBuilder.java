package compelete;

public class QueryBuilder<T> {

    private Query<T> q;

    public QueryBuilder(Query<T> q){
        this.q = q;
    }

    public static <T> QueryBuilder<T> createQuery() {
        return new QueryBuilder<>(new Query<>());
    }

    public QueryBuilder<T> withParamName(String paramName) {
        q.setqParamName(paramName);
        return this;
    }

    public QueryBuilder<T> withValue(T value) {
        q.setqValue(value);
        return this;
    }

    public QueryBuilder<T> withAction(QACTION action) {
        q.setqAction(action);
        return this;
    }

    public Query build() {
        return q;
    }
}
