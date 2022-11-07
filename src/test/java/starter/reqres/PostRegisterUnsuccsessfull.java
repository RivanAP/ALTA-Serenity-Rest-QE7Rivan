package starter.reqres;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class PostRegisterUnsuccsessfull {
    @Steps
    ReqresAPI postregisterUnsuccsess;
    @Given("Post Register user with email json")
    public void postRegisterUserWithEmailJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterUnsuccess.json");
        postregisterUnsuccsess.PostResgisterUnsuccsessfull(json);
    }

    @And("Validate Post Register user json schema")
    public void validatePostRegisterUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostRegisterUnsuccsessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
