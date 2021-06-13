package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CreateUserSteps;

@WithTags(
        {
                @WithTag("Create User tests"),

        }
)

@Feature
@RunWith(SerenityRunner.class)
public class CreateUserTest {

    @Steps
    CreateUserSteps createUserSteps;


    @Test
    @WithTag("Test-01")
    @Title("Verify create a new user with valid name and job")
    public void verifyCreateANewUserWithValidNameAndJob() {
        createUserSteps.whenCreateNewUserWithNameAndJob("John", "Doctor");
        createUserSteps.thenResponseCodeShouldBe("201");
    }

    @Test
    @WithTag("Test-02")
    @Title("Verify get details of single user")
    public void verifyGetDetailsOfSingleUser() {
        createUserSteps.givenNewUserId("Jhoshep", "Engineer");
        createUserSteps.whenGetDetailsOfSingleUser();
        createUserSteps.thenResponseCodeShouldBe("200");
    }



}
