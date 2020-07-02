package br.ce.dfoliveira.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTest {
    @Test
    public void testOlaMundo()
    {
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertTrue(response.statusCode() == 200);
        Assert.assertTrue("O status code deveria ser 200",response.statusCode() == 200);
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        get("http://restapi.wcaquino.me/ola").then().statusCode(200);

        given()
        .when()
                .get("http://restapi.wcaquino.me/ola")
        .then()
                .statusCode(200);
    }

}
