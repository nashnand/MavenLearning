import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

// https://reqres.in/ used for below example

public class Rest_02_Post {
@Test
    public void postrequest(){
        //Get URI
        RestAssured.baseURI=("https://reqres.in/api/");
        //Get request object
        RequestSpecification httprequest=RestAssured.given();

        //JSON object -Sending data aling with post request
        JSONObject requestparam = new JSONObject();
        requestparam.put("name","Anand");
        requestparam.put("job","Manager");
        httprequest.header("Content-Type","application/json");
        httprequest.body(requestparam.toJSONString());

        Response RespStatus =httprequest.request(Method.POST,"/api/users");
        String Httpstatus= RespStatus.getBody().asString();
        System.out.println(Httpstatus);
        int ActStatus = RespStatus.getStatusCode();
        System.out.println("Status code "+ActStatus);
                Assert.assertEquals(ActStatus,201);

    }
}
