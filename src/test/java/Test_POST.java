import io.restassured.http.ContentType;
import jdk.nashorn.api.scripting.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import sun.font.CStrike;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_POST {

    @Test
    public void Test_Post_1(){
        //JSON to be passed for POST call can be made using map as below or JSON library can also be used

        Map<String, Object> map= new HashMap<String, Object>();

        map.put("name","Testname");
        map.put("job","Job1");
        System.out.println(map);

        //Using JSON.simple library
        JSONObject request = new JSONObject(map);
        System.out.println(request);
        System.out.println(request.toJSONString());


        //without using map
        JSONObject request1 = new JSONObject();
        request1.put("name","Testname2");
        request1.put("job","Job2");
        System.out.println(request1.toJSONString());


        //Sending the POST request
        given().
                header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().post("https://reqres.in/api/users").then().statusCode(201);


    }
}
