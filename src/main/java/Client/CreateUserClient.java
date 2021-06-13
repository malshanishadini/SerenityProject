package Client;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import utils.Templates;
import java.io.IOException;


public class CreateUserClient {

    static String createUserUrl = "https://reqres.in/api/users";
    static String getSingleUserUrl = "https://reqres.in/api/users/";

    public static Response sendCreateUserRequestAndReceivedResponse(String requestBody) {

        return SerenityRest
                .given()
                .contentType("application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post(createUserUrl)
                .then()
                .extract()
                .response();

    }

    public static Response sendGetSingleUserDetailsRequestAndReceiveResponse(String id){
        return SerenityRest
                .given()
                .contentType("application/json")
                .when()
                .log().all()
                .get(getSingleUserUrl+id)
                .then()
                .extract()
                .response();

    }


    public static String createUserRequest(String name, String job) {
        String createUserRequest = "";

        try {
            String createUserRequestTemplate = new Templates().getRequestTemplate("CreateUserRequest");
            if (name != null) {
                createUserRequest = createUserRequestTemplate.replace("${name}", name);
            } else {
                createUserRequest = createUserRequestTemplate.replace("${name}", "");
            }
            createUserRequestTemplate = createUserRequest;

            if (job != null) {
                createUserRequest = createUserRequestTemplate.replace("${job}", job);
            } else {
                createUserRequest = createUserRequestTemplate.replace("${job}", "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return createUserRequest;
    }


}
