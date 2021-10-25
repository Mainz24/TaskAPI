import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Тесты работы с API клиента")
@Feature("Api for users")
public class CheckUsers {

    @Test
    @DisplayName("Подтверждение email пользователя George Bluth")
    @Story("List all users")
    public void getUsersGeorg(){
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.find{it.first_name == 'George'}.email",
                        equalTo("george.bluth@reqres.in"));
    }

    @Test
    @DisplayName("Подтверждение email пользователя Michael Lawson")
    @Story("List all users")
    public void getUsersMichael() {
        given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.find{it.first_name == 'Michael'}.email",
                        equalTo("micharl.lawson@reqres"));
    }
}
