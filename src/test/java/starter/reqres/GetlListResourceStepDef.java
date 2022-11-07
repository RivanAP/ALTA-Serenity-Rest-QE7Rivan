package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetlListResourceStepDef {
    @Steps
    ReqresAPI getlistResource;
    @Given("GetList user Resource with valid {int}")
    public void getlistUserResourceWithValidPagePage(int page) {
        getlistResource.getlishResource(page);
    }
    @When("Send Get List user Resource Request")
    public void sendGetListUserResourceRequest() {
        SerenityRest.when().get(ReqresAPI.GETLIST_RESOURCE);
    }
    @And("Response body page Should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
    @And("Validate Get list resource user json schema")
    public void validateGetlistResourceUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
