package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostRegisterSuccsessStepDef {
    @Steps
    ReqresAPI PostRegisterSuccsess;

    @Given("Post Register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterSuccess.json");
        PostRegisterSuccsess.PostRegisterSuccsess(json);
    }
    @When("Send Post Register user request")
    public void sendPostRegisterUserRequest() {

        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCSESS);
    }
    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int Status) {
        SerenityRest.then().statusCode(Status);
    }
    @And("Responde body should contain id {int} and token {string}")
    public void respondeBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate Register user json schema")
    public void validateRegisterUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostRegiterSuccessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Post Register user without email json")
    public void postRegisterUserWithoutEmailJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterWithoutEmail.json");
        PostRegisterSuccsess.PostRegisterSuccsess(json);
    }

    @Then("Response code should be {int} Bad Request")
    public void responseCodeShouldBeBadRequest(int Status) {
        SerenityRest.then().statusCode(Status);
    }

    @And("Responde body should contain error {string}")
    public void respondeBodyShouldContainError(String Email) {
      SerenityRest.then().body(ReqresResponses.ERROR,equalTo(Email));
    }

    @Given("Post Regiter user without Password json")
    public void postRegiterUserWithoutPasswordJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterWithoutPassword.json");
        PostRegisterSuccsess.PostRegisterSuccsess(json);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String Password) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(Password));
    }
}
