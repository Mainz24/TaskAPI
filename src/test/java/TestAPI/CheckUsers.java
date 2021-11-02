package TestAPI;

import TestAPI.Pogo.ListUsers;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;

public class CheckUsers {
    @Test
    public void getUserGeorg() {
        List<ListUsers> userGeorg = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", ListUsers.class);
        assertThat(userGeorg).extracting(ListUsers::getFirst_name).contains("Georg");
        assertThat(userGeorg).extracting(ListUsers::getLast_name).contains("Bluth");
        assertThat(userGeorg).extracting(ListUsers::getEmail).contains("george.bluth@reqres.in.");
    }
    @Test
    public void getUserMichael() {
        List<ListUsers> userMichael = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", ListUsers.class);
        assertThat(userMichael).extracting(ListUsers::getFirst_name).contains("Michael");
        assertThat(userMichael).extracting(ListUsers::getLast_name).contains("Lawson");
        assertThat(userMichael).extracting(ListUsers::getEmail).contains("michael.lawson@reqres");
    }
}
