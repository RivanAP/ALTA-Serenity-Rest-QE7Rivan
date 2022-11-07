package starter.reqres;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class GetListSingleUserStepDef {
    @Steps
    ReqresAPI getListSingleUser;
    @Given("Get list single user with id {int}")
    public void getListSingleUserWithIdId(int id) {
        getListSingleUser.getListSingleUser(id);
    }
    @When("Send get list single user request")
    public void sendGetListSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GETlIST_SINGLE_USER);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page mush be {int}")
    public void responseBodyPageMushBeId(int id)  {
        SerenityRest.then().body(ReqresResponses.DATA,equalTo(id));
    }
    @And("Validate get list single user json schema")
    public void validateGetListSingleUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get list single user with invalid id {int}")
    public void getListSingleUserWithIdInvalidID(int id) {
        getListSingleUser.getListSingleUser(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }



}
