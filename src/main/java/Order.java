import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order implements OrderI{
    @JsonProperty("total_price")   private Double price;
    @JsonProperty("email")         private String email;
    @JsonProperty("obj1")          private OBJ1 obj;

    @JsonCreator
    public Order(@JsonProperty("total_price") Double price,
                 @JsonProperty("email") String email,
                 @JsonProperty("obj1") OBJ1 obj
                 )

    {
        this.price = price;
        this.email = email;
        this.obj = obj;
    }

    //Order Action performs this query by running its action, on order setParam value VS query setPattern to be queried
    @Override
    public boolean isQueryMatch(QueryableI query) throws Exception{
        System.out.println("performing action on " + query);

        Comparator queryComparator = ComparatorFactory.createComparator(query.getQAction());

        // todo - can generalize this "Object" to T and if really needed by passing the Class of Query.class type creating with
        // T elem = cls.newInstance(); and returning it !
        Object orderParamValue = getValueOfParam(query.getQParamName());
        //List<String> orderParamValue = getListValueOfParam(query.getQParamName());
        System.out.println("o value as Object " + orderParamValue);
        System.out.println("o value getClass() " + orderParamValue.getClass());
        System.out.println("q value as T " + query.getQValue());
        System.out.println("q value getClass() " + query.getQValue().getClass());
        return queryComparator.compare(orderParamValue, query.getQValue()) == 0;   //0 is true

    }

    @Override
    public boolean isCompositeQueryMatch(List<QueryableI> queries) throws Exception {
        for (QueryableI q : queries) {
            if (!isQueryMatch(q))
                return false;
        }
        return true;
    }


    private Object getValueOfParam(String paramName) throws Exception{
        Object returnValue = null;
        for (Field f : Order.class.getDeclaredFields()) {
            //System.out.println("f.getName() " + f.getName());    //if want to access according actual field name
            JsonProperty annotation = f.getAnnotation(JsonProperty.class);
            if (annotation != null) {
                //System.out.println("AV " + annotation.value());
                if (annotation.value().equals(paramName)){
                    System.out.format("found AV for %s it's %s\n ",annotation.value(), f.get(this));
                    returnValue = f.get(this);    //value null is not valid - should be ""
                    break;
                }
            }
        }

        //param not found - should not happened - but this way it supports HasParamQuery
        if(returnValue == null) {
            System.err.format("Query param %s don't exist in %s\n ",paramName, this );
            return Collections.emptyList();
            //throw new IllegalAccessException("Query param '" + paramName + "' don't exist in " + this);
        }

        return returnValue;
    }

//    public String getTotalPrice() {
//        return price;
//    }
//
////    public void setPrice(String price) {
////        this.price = price;
////    }
//
//    public String getEmail() {
//        return email;
//    }
////
////    public void setEmail(String email) {
////        this.email = email;
////    }


    @Override
    public String toString() {
        return "Order{" +
                "price='" + price + '\'' +
                ", email='" + email + '\'' +
                ", obj='" + obj + '\'' +
                '}';
    }
}

//todo try finding a better way
