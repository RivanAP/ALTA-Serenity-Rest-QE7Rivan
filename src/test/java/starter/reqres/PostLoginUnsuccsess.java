package starter.reqres;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.File;

public class PostLoginUnsuccsess {
    @Steps
    ReqresAPI PostLoginUnsuccsessfull;
    @Given("Post Login Unsuccsess user with valid json")
    public void postLoginUnsuccsessUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLoginUnsuccsess.json");
        PostLoginUnsuccsessfull.PostLoginUnsucsessFull(json);
    }

    @And("Validate Post Login Unsuccsss user json schema")
    public void validatePostLoginUnsuccsssUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginUnsuccsessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
