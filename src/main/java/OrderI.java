import java.util.List;

public interface OrderI {

    boolean isQueryMatch(QueryableI query) throws Exception;
    boolean isCompositeQueryMatch(List<QueryableI> queries) throws Exception;
}


