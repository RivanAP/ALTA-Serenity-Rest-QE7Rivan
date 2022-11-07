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

public class GetListSingleResourceStepDef {
    @Steps
    ReqresAPI GetListSingleResource;
    @Given("GetList Single Resource with valid {int}")
    public void getlistSingleResourceWithValidId(int id) {
        GetListSingleResource.getlishSingleResource(id);
    }
    @When("Send Get List Single Resource Request")
    public void sendGetListSingleResourceRequest() {
        SerenityRest.when().get(ReqresAPI.GETLIST_SINGLE_RESOURCE);
    }

    @Then("Response body page by {int}")
    public void responseBodyPageBy(int id) {
        SerenityRest.then().body(ReqresResponses.DATA, equalTo(id));
    }

    @And("Validate Get list Single resource json schema")
    public void validateGetListSingleResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListSingleResourceJsonSchema.Json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get List Single Resource with invalid {int}")
    public void getListSingleResourceWithInvalidId(int id) {
        GetListSingleResource.getlishSingleResource(id);
    }


    @And("Validate get list single Resorce Not Found json schema")
    public void validateGetListSingleResorceNotFoundJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetlListSingleResourceNotFoundJsonSchema.Json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
