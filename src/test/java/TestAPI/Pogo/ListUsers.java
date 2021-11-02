package TestAPI.Pogo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ListUsers {
    private String email;
    private String first_name;
    private String last_name;

    public String getEmail() {
        return email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
}
