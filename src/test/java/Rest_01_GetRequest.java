import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

// https://reqres.in/ used for below example
//https://www.javadoc.io/doc/io.rest-assured/rest-assured/3.0.6/io/restassured/RestAssured.html#given--

public class Rest_01_GetRequest {
        @Test
        public static void Getrequest()
        {
            //Specify base URI
            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
            //Request object
            RequestSpecification httprequest = RestAssured.given();
            //Response object
            Response httpresponse = httprequest.request(Method.GET, "/employees");
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


