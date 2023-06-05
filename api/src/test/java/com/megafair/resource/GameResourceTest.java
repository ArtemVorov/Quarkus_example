package com.megafair.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(GameResource.class)
class GameResourceTest {

    @Test
    @TestSecurity(user = "platform", roles = {"user"})
    void redirectToGameWrongAuthorization() {
        JsonObject jsonItem = Json
                .createObjectBuilder()
                .add("id", "1")
                .add("name", "platform1")
                .build();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonItem.toString())
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(Response.Status.FORBIDDEN.getStatusCode());
    }

    @Test
    void redirectToGameNoAuthorization() {
        JsonObject jsonItem = Json
                .createObjectBuilder()
                .add("id", "1")
                .add("name", "platform1")
                .build();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonItem.toString())
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(Response.Status.UNAUTHORIZED.getStatusCode());
    }

}