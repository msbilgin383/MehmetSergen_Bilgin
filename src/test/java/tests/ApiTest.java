package tests;

import ApiTest.BaseUrlApi;
import ApiTest.Pojos.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiTest extends BaseUrlApi {

    @Test
    public void testGetById() {
        requestSpec.pathParam("pp1",7);
        Category category = new Category(1,"dog");
        Tag[] tags = new Tag[1];
        tags[0] = new Tag(1,"ccc");
        String[] photoUrls = {"url1"};
        GetByIdResponse getByIdResponse = new GetByIdResponse(7, category, "vvvvvvvvv", photoUrls, tags, "available");

        Response response = given().spec(requestSpec).when().get("{pp1}");
        response.prettyPrint();
        GetByIdResponse responseBody = response.as(GetByIdResponse.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(getByIdResponse.getId(), responseBody.getId());
        assertEquals(getByIdResponse.getCategory().getId(), responseBody.getCategory().getId());
        assertEquals(getByIdResponse.getCategory().getName(), responseBody.getCategory().getName());
        assertEquals(getByIdResponse.getName(), responseBody.getName());
        assertEquals(getByIdResponse.getPhotoUrls()[0], responseBody.getPhotoUrls()[0]);
        assertEquals(getByIdResponse.getTags()[0].getId(), responseBody.getTags()[0].getId());
        assertEquals(getByIdResponse.getTags()[0].getName(), responseBody.getTags()[0].getName());
        assertEquals(getByIdResponse.getStatus(), responseBody.getStatus());
    }
    @Test
    public void testPost(){
        Category category = new Category(1,"dog");
        Tag[] tags = new Tag[1];
        tags[0] = new Tag(1,"ccc");
        String[] photoUrls = {"url1"};
        PostNewPetRequest postNewPetRequest = new PostNewPetRequest(category, "beto", photoUrls, tags, "adopted");

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(requestSpec)
                .body(postNewPetRequest)
                .when()
                .post();
        response.prettyPrint();
        PostNewPetResponse responseBody = response.as(PostNewPetResponse.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(postNewPetRequest.getCategory().getId(), responseBody.getCategory().getId());
        assertEquals(postNewPetRequest.getCategory().getName(), responseBody.getCategory().getName());
        assertEquals(postNewPetRequest.getName(), responseBody.getName());
        assertEquals(postNewPetRequest.getPhotoUrls()[0], responseBody.getPhotoUrls()[0]);
        assertEquals(postNewPetRequest.getTags()[0].getId(), responseBody.getTags()[0].getId());
        assertEquals(postNewPetRequest.getTags()[0].getName(), responseBody.getTags()[0].getName());
        assertEquals(postNewPetRequest.getStatus(), responseBody.getStatus());
    }
    @Test
    public void testPut(){
        Category category = new Category(1,"dog");
        Tag[] tags = new Tag[1];
        tags[0] = new Tag(1,"ccc");
        String[] photoUrls = {"url1"};
        PutPetRequest putPetRequest = new PutPetRequest(10, category, "beto", photoUrls, tags, "adopted");

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(requestSpec)
                .body(putPetRequest)
                .when()
                .put();
        response.prettyPrint();
        PutPetResponse responseBody = response.as(PutPetResponse.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(putPetRequest.getId(), responseBody.getId());
        assertEquals(putPetRequest.getCategory().getId(), responseBody.getCategory().getId());
        assertEquals(putPetRequest.getCategory().getName(), responseBody.getCategory().getName());
        assertEquals(putPetRequest.getName(), responseBody.getName());
        assertEquals(putPetRequest.getPhotoUrls()[0], responseBody.getPhotoUrls()[0]);
        assertEquals(putPetRequest.getTags()[0].getId(), responseBody.getTags()[0].getId());
        assertEquals(putPetRequest.getTags()[0].getName(), responseBody.getTags()[0].getName());
        assertEquals(putPetRequest.getStatus(), responseBody.getStatus());
    }
    @Test
    public void testDelete(){
        int deletedId = 172;
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete(Integer.toString(deletedId));
        response.prettyPrint();
        DeletePetResponse responseBody = response.as(DeletePetResponse.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(200, responseBody.getCode());
        assertEquals("unknown", responseBody.getType());
        assertEquals(Integer.toString(deletedId), responseBody.getMessage());

    }

}


