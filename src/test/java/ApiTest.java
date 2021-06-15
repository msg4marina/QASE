import Models.Project;
import Models.ResponseProject;
import Models.ResponseStatus;
import adapters.ProjectAdapter;
import lombok.Builder;
import lombok.Data;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertEquals;

@Data
@Builder
public class ApiTest {
    @Test
    public void projectTest(){
        given().
                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                header("Content-Type", "application/json").
                body("{}").
        when().
                post("https://api.qase.io/v1/project").
        then().
                log().all().
                statusCode(200).
                body("errorMessage", equalTo("Data is invalid"),
                        "errorMessage", equalTo(" "));

    }

}