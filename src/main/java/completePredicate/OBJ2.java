package completePredicate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OBJ2 {

    @JsonProperty("name")        private String name;
    @JsonProperty("last_name")   private String lastName;

    @JsonCreator
    public OBJ2(@JsonProperty("name")       String name,
                @JsonProperty("last_name")  String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "OBJ2{" +
                "name='" + name + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OBJ2 obj2 = (OBJ2) o;
        return Objects.equals(name, obj2.name) &&
                Objects.equals(lastName, obj2.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}


