package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;

public class GetMethodsCompanies {

    @Test(groups = {"all",  "getMethods", "getAllUsers", "companies"}, description = "getAllCompanies API")
    public void getAllUsers(){
//        String base = "http://localhost:5000/users/";
        String base = "http://localhost:5000/companies/";
        String url = base + "all/";
        Response response = RequestMaker.makeGetRequest(url);
        String responseString = response.asString();
        JSONArray jsonResponse = new JSONArray(responseString);

        System.out.println(jsonResponse.toString(10));

    }
}
