package apiTestingAuxClasses;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;
import org.json.JSONObject;

public class CreateBodyContent {

    public static String getBodyContentUsers(){
        JSONObject body = new JSONObject();

        Faker faker = new Faker();
        Name name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        String userName = name.username();
        String email = faker.internet().emailAddress();
        body.put("username", userName)
                .put("firstname", firstName)
                .put("lastname", lastName)
                .put("email", email);
        return body.toString();
    }
    public static String getBodyContentCompanies(){
        JSONObject body = new JSONObject();

        Faker faker = new Faker();
        Name name = faker.name();
        String companyName = name.nameWithMiddle();
        String street = faker.address().streetAddress();
        String phoneNumber = faker.number().digits(10);
        body.put("companyname", companyName)
                .put("street", street)
                .put("phonenumber", phoneNumber);
        return body.toString();
    }
}