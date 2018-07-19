package compelete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("total_price")   private Double price;
    @JsonProperty("email")         private String email;
    @JsonProperty("obj1")          private OBJ2 obj;

    @JsonCreator
    public Order(@JsonProperty("total_price") Double totalPrice,
                 @JsonProperty("email") String email,
                 @JsonProperty("obj1") OBJ2 obj
                 )

    {
        this.price = totalPrice;
        this.email = email;
        this.obj = obj;
    }


    public Double getTotalPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OBJ2 getObj() {
        return obj;
    }

    public void setObj(OBJ2 obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", email='" + email + '\'' +
                ", obj=" + obj +
                '}';
    }
}
