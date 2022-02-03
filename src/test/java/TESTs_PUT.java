import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TESTs_PUT {

    @Test
    public void PUT_TESt1(){

        JSONObject putreq1 = new JSONObject();
        putreq1.put("name","Putname1");
        putreq1.put("job","putjob1");

         given().
                 header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
                 body(putreq1.toJSONString()).
                    when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();

    }
}
