package steps;

import Client.CreateUserClient;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserSteps.class);
    private CreateUserClient createUserClient = new CreateUserClient();
    private Response response;
    private String id;

    @Given("new user id")
    public String givenNewUserId(final String name, final String job){
        final String request = createUserClient.createUserRequest(name, job);
        response = createUserClient.sendCreateUserRequestAndReceivedResponse(request);
        LOGGER.info("<<< Create User Response \n" + response.getBody().prettyPrint());

        Assert.assertNotNull(response);
        id = response.jsonPath().getString("id");

        return id;

    }

    @When("create new user with name {0} and job {1}")
    public void whenCreateNewUserWithNameAndJob(final String name, final String job) {
        final String request = createUserClient.createUserRequest(name, job);
        LOGGER.info(">>> Create User Request \n" + request);
        response = createUserClient.sendCreateUserRequestAndReceivedResponse(request);
        LOGGER.info("<<< Create User Response \n" + response.getBody().prettyPrint());

    }

    @When("get details of single user")
    public void whenGetDetailsOfSingleUser(){
        response = createUserClient.sendGetSingleUserDetailsRequestAndReceiveResponse(id);
        LOGGER.info("<<< Create User Response \n" + response.getBody().prettyPrint());

    }

    @Then("Response code should be {0}")
    public void thenResponseCodeShouldBe(final String expectedResponseCode) {
        Assert.assertNotNull(response);
        Assert.assertEquals(Integer.parseInt(expectedResponseCode), response.getStatusCode());

    }


}
