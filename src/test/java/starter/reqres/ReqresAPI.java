package starter.reqres;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.assertj.core.internal.Urls;
import org.openqa.selenium.json.Json;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USER = URL +"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL +"/api/users";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";
    //tugas
    public static String GETlIST_SINGLE_USER = URL+"/api/users/{id}";
    public static String GETLIST_RESOURCE = URL+"/api/unknown{page}";
    public static String GETLIST_SINGLE_RESOURCE = URL+"/api/unknown/{page}";
    public static String POST_REGISTER_SUCCSESS = URL+"/api/register";
    public static String POST_LOGIN_SUCCSESS = URL+"/api/login";
    public static String GET_DELAY_RESPONSE = URL+"/api/users?delay={page}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    //tugas
    @Step("Get list single user")
    public void getListSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON);
    }
    @Step("Getlist Resource")
    public  void getlishResource(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Getlish Single Resource")
    public void getlishSingleResource(int page){
        SerenityRest.given()
                .pathParam("page",page)
                .contentType(ContentType.JSON);
    }
    @Step("Post Register Succsess")
    public void PostRegisterSuccsess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Register UnSuccsessfull")
    public void PostResgisterUnsuccsessfull(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Login SuccessFull")
    public void PostLoginSucsessFull(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Login UnSuccessFull")
    public void PostLoginUnsucsessFull(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get Delay Response")
    public void getDelay(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

}

