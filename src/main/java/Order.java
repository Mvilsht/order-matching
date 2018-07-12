import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order implements OrderI{

    @JsonProperty("total_price")   private double price;
    @JsonProperty("email")         private String email;

    @JsonCreator
    public Order(@JsonProperty("total_price") double price,
                 @JsonProperty("email")String email)
    {
        this.price = price;
        this.email = email;
    }

    public void performAction(Query query) {
        //query.getComperator();
    }
}
