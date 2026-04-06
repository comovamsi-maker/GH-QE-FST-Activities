package RESTAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {

    int petId = 77232;

    @Test(priority = 1)
    public void addNewPet() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", petId);
        reqBody.put("name", "Riley");
        reqBody.put("status", "available"); // ✅ FIXED

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType("application/json")
                .body(reqBody)
                .when()
                .post();

        // ✅ Assertions
        response.then().statusCode(200);
        response.then().body("id", equalTo(petId));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("available"));
    }

    @Test(priority = 2)
    public void getPetInfo() {

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType("application/json")
                .pathParam("petId", petId)
                .when()
                .get("/{petId}");

        // ✅ Assertions
        response.then().statusCode(200);
        response.then().body("id", equalTo(petId));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("available"));
    }

    @Test(priority = 3)
    public void deletePet() {

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType("application/json")
                .pathParam("petId", petId)
                .when()
                .delete("/{petId}");

        // ✅ Assertions (safer)
        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
    }
}