import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

// https://reqres.in/ used for below example

public class Rest_03_Put {
@Test
    public static void putrequest(){
        //Get uri
        RestAssured.baseURI= "https://reqres.in/api/users/";
        //Get Request
        RequestSpecification httprequest=RestAssured.given();
        //Printing before udpating
        System.out.println("Before updating"+ httprequest.request(Method.GET,"/2").getBody().asString());
        //Build json
        JSONObject Param= new JSONObject();
        Param.put("name","ANAND");
        Param.put("job","Krishnan");

        httprequest.header("Content-Type","application/json");
        Response httpresponse= httprequest.request(Method.PUT,"/2");
        // Get Response
        String Resp = httpresponse.body().asString();
        System.out.println("Updating "+Resp);
        //Printing before udpating
        System.out.println("After updating"+ httprequest.request(Method.GET,"/2").getBody().asString());
        //convert response to string
        //Assert
     int status = httpresponse.statusCode();
     System.out.println("Status code"+status);
     Assert.assertEquals(status,200);


    }
}
