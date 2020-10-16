package apiTesting;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetMethodsUsers {

    @Test(groups = {"all",  "getMethods", "getAllUsers"}, description = "getAllUsers API")
    public JSONArray getAllUsers(){
        String url = "https://localhost:5000/users/all";

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                //.assertThat().statusCode(200)
                .extract().response();
        String responseString = response.asString();
        JSONArray jsonResponse = new JSONArray(responseString);
        System.out.println(jsonResponse.toString(10));
        return(jsonResponse);
    }
}
