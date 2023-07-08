package com.mrodrigochaves;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;



@Path("/request")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RequestService<Block> {

    @POST
    @Path("/block")

    public Response createBlock(Block block) {
        
        Response response = (Response) RestAssured.given()
                .contentType("application/json")
                .body(block)
                .post("http://localhost:8081/block"); 
                
        return Response.status(((ResponseOptions<io.restassured.response.Response>) response).getStatusCode()).entity(((ResponseOptions<io.restassured.response.Response>) response).getBody().asString()).build();
    }

   
}
