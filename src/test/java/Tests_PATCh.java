import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Tests_PATCh {

    @Test
    public void PATCH_Test1(){
        JSONObject PATCHreq = new JSONObject();
        PATCHreq.put("name", "PatchName1");
        PATCHreq.put("job", "Patch-Job1");

        given().
                header("Content-Type","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON).
                body(PATCHreq.toJSONString()).
                when().patch("https://reqres.in/api/users/2").
                    then().statusCode(200).log().all();
    }
}
