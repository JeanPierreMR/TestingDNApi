package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import io.restassured.response.Response;
import org.apache.tools.ant.taskdefs.Get;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RemoveEven {
    @Test(groups = {"all", "delMethod", "removeUser"}, description = "createNewUser API", dataProvider = "getBodyContentAndOption")
    public void removeEvenUsers(String bodyContent) {
        String base = "http://localhost:5000/users/";
        //String base2 = "http://localhost:5000/companies/";
        String url = base + "removebyid/";

        GetMethodsUsers userGetter = new GetMethodsUsers();
        JSONArray users = userGetter.getAllUsers();
        int id1 = (int) ((JSONObject) users.get(0)).get("id");
        int id2 = (int) ((JSONObject) users.get(users.length() - 1)).get("id");
        if (id1 % 2 != 0){//odd
            id1+=1;
        }
        for (int i = id1; i <= id2; id1 += 2) {
            Response response = RequestMaker.makeDeleteRequest(url + (int) i );
            String responseString = response.asString();
            JSONObject jsonResponse = new JSONObject(responseString);
            System.out.println(jsonResponse.toString(10));
        }

    }
}