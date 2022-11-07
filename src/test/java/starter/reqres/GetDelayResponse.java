package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetDelayResponse {
    @Steps
    ReqresAPI getDelayResponse;
    @Given("Get Delay with parameter page {int}")
    public void getDelayWithParameterPagePage(int id) {
        getDelayResponse.getDelay(id);
    }

    @When("Send Get Delay user Request")
    public void sendGetDelayUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_DELAY_RESPONSE);
    }

    @And("Response body Page Should be {int}")
    public void responseBodyPageShouldBePageID(int id) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(id));
    }

    @And("Validate Delay Response json schema")
    public void validateDelayResponseJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetDelayResponseJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
