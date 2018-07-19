import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OBJ1 {
    @JsonProperty("name")        private String name;
    @JsonProperty("last_name")   private String last_name;

    @JsonCreator
    public OBJ1(@JsonProperty("name") String name,
                @JsonProperty("last_name") String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "OBJ1{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OBJ1 obj1 = (OBJ1) o;
        return Objects.equals(name, obj1.name) &&
                Objects.equals(last_name, obj1.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, last_name);
    }
}
