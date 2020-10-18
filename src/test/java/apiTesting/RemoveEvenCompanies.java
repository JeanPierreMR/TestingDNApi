package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class RemoveEvenCompanies {
    @Test(groups = {"all", "delMethod", "removeUser", "companies"}, description = "Removes Companies API")
    public void removeEvenUsers() {
//        String base = "http://localhost:5000/users/";
        String base = "http://localhost:5000/companies/";
        String url = base + "removebyid/";

        String urlGetAll = "http://localhost:5000/users/all";
        Response responseGetAll = RequestMaker.makeGetRequest(urlGetAll);
        String responseStringGetAll = responseGetAll.asString();
        JSONArray users = new JSONArray(responseStringGetAll);

        int id1 = (int) ((JSONObject) users.get(0)).get("id");
        int id2 = (int) ((JSONObject) users.get(users.length() - 1)).get("id");
        if (id1 % 2 != 0){//odd
            id1+=1;
        }
        System.out.println("adfoiad;fg");
        for (int i = id1; i <= id2; i += 2) {
            System.out.println("adfoiad;fg2");
            Response response = RequestMaker.makeDeleteRequest(url + (int) i );
            String responseString = response.asString();
            JSONObject jsonResponse = new JSONObject(responseString);
            System.out.println(jsonResponse.toString(10));
        }

    }
}