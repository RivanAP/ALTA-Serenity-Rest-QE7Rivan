package starter.reqres;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class PostLoginSuccsess {
    @Steps
    ReqresAPI PostLoginSuccsessfully;

    @Given("Post Login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLoginSuccsess.json");
        PostLoginSuccsessfully.PostLoginSucsessFull(json);
    }

    @When("Send Post Login user request")
    public void sendPostLoginUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCSESS);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String Status) {
       SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(Status));
    }

    @And("Validate Post Login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginSuccsessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post Login user without email")
    public void postLoginUserWithoutEmail() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLoginWithoutEmail.json");
        PostLoginSuccsessfully.PostLoginSucsessFull(json);
    }

    @Given("Post Login user without Password")
    public void postLoginUserWithoutPassword() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLoginWithoutPassword.json");
        PostLoginSuccsessfully.PostLoginSucsessFull(json);
    }
}
