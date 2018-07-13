import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.Comparator;

public class Order implements OrderI{

    @JsonProperty("total_price")   private String price;
    @JsonProperty("email")         private String email;

    @JsonCreator
    public Order(@JsonProperty("total_price") String price,
                 @JsonProperty("email") String email)
    {
        this.price = price;
        this.email = email;
    }

    //Order Action performs this query by running its action, on order setParam value VS query setPattern to be queried
    public boolean performActionIsMatch(Query2 query) throws Exception{
        System.out.println("performing action on " + query);

        Comparator<String> queryComparator = ComparatorFactory.createComparator(query.getQAction());

        String paramValue = getValueOfParam(query.getQParamName());

        return queryComparator.compare(paramValue, query.getQPattern()) == 0;   //0 is true

    }

    //todo try finding a better way
     private String getValueOfParam(String paramName) throws IllegalAccessException{

         String returnValue = null;
         for (Field f : Order.class.getDeclaredFields()) {
             //System.out.println("f.getName() " + f.getName());    //if want to access according actual field name
             JsonProperty annotation = f.getAnnotation(JsonProperty.class);
             if (annotation != null) {
                 //System.out.println("AV " + annotation.value());
                 if (annotation.value().equals(paramName)){
                     System.out.format("found AV for %s it's %s\n ",annotation.value(), f.get(this));
                     returnValue = (String) f.get(this);    //value null is not valid - should be ""
                     break;
                 }
             }
         }

         //param not found
         if(returnValue == null) {
             System.err.format("Query param %s don't exist in %s\n ",paramName, this );
             throw new IllegalAccessException("Query param '" + paramName + "' don't exist in " + this);
         }

        return returnValue;
     }

//    public String getPrice() {
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
                "price=" + price +
                ", email='" + email + '\'' +
                '}';
    }

}
