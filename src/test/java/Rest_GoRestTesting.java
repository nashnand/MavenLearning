import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Rest_GoRestTesting {

    @Test
    public static void GoRestrequest() {
        RestAssured.baseURI = "https://gorest.co.in/public-api/";
        RequestSpecification httpreq = RestAssured.given();
        httpreq.request(Method.GET,"");
        Response httpresponse = httpreq.request(Method.GET, "/users");
        System.out.println(httpresponse.getBody().asString());

    }

}