import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class Test01_GETReq {

    @Test
    void test_01(){
        //Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.contentType());

        Assert.assertEquals(response.getStatusCode(),200);
    }

    //The import can be made static, in that case there wil be no need to create object of Response; get method can be called directly
    //import io.restassured.RestAssured; to import static io.restassured.RestAssured.*;

    @Test
    void test_02(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }

}
