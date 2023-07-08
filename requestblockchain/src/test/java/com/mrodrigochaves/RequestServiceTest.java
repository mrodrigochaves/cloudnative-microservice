package com.mrodrigochaves;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class RequestServiceTest<Block> {

    @Test
    public void testCreateBlock() {
        Block block = new Block("Data", "PreviousHash", System.currentTimeMillis());
        ((Object) block).setNonce(123);

        Response response = given()
            .contentType(ContentType.JSON)
            .body(block)
        .when()
            .post("/request/block")
        .then()
            .statusCode(200)
            .extract().response();

    
    }
}
