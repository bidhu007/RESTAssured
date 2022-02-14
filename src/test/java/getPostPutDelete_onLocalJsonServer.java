import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class getPostPutDelete_onLocalJsonServer {

    //@Test
    public void test_get(){
        baseURI = "http://localhost:3000/";
        given().
                param("name","Automation").
                get("/subjects").then()
                .statusCode(200).log().all();
    }

    //@Test
    public void test_post(){
        baseURI = "http://localhost:3000/";

        JSONObject req = new JSONObject();
        req.put("firstName","Tom");
        req.put("lastName","Cooper");
        req.put("subjectId",1);

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(req.toJSONString())
                .when().post("/users")
                .then()
                .statusCode(201).log().all();

    }

    //@Test
    public void test_patch(){
        baseURI = "http://localhost:3000/";

        JSONObject req = new JSONObject();

        req.put("lastName","shepherd");


        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(req.toJSONString())
                .when().patch("/users/4")
                .then()
                .statusCode(200).log().all();

    }

    //@Test
    public void test_put(){
        baseURI = "http://localhost:3000/";

        JSONObject req = new JSONObject();

        req.put("firstName","Mary");
        req.put("lastName","Jane");
        req.put("subjectId",1);


        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(req.toJSONString())
                .when().put("/users/4")
                .then()
                .statusCode(200).log().all();

    }

    @Test
    public void test_delete(){
        baseURI = "http://localhost:3000/";

        when().delete("/users/4").then().statusCode(200);

    }


}
