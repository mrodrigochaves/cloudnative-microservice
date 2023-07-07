package com.mrodrigochaves;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BlockTest {

    @Test
    public void testBlockCreation() {
        Block block = new Block("Data", "PreviousHash", System.currentTimeMillis());
        block.setNonce(123);

        String expectedHash = block.calculateBlockHash();

        given()
            .contentType("application/json")
            .body(block)
        .when()
            .post("/blocks")
        .then()
            .statusCode(200)
            .body("hash", is(expectedHash));
    }
}
