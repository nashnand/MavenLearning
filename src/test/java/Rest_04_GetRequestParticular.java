import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

// https://reqres.in/ used for below example

public class Rest_04_GetRequestParticular {
    @Test
    public static void getemployeedetails() {
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in/api/users/";
        //Request object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response httpresponse = httprequest.request(Method.GET, "/6");
        //Print response
        String Responsebody = httpresponse.getBody().asString();
        System.out.println("Response body" + Responsebody);
        //status code validation
        int getStatus = httpresponse.getStatusCode();
        Assert.assertEquals(getStatus, 200);
        //Status line
        String statusline = httpresponse.getStatusLine();
        System.out.println("Status line" + statusline);
        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
    }
}
