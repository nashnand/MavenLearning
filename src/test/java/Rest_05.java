import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Rest_05 {

    @Test(enabled = false)
    public void GETAPI() {
        Response getresponse = given().param("Page", "2").
                auth().none().
                when().get("https://reqres.in/api/users");
        System.out.println(getresponse.getStatusCode());
        int statucode = getresponse.getStatusCode();
        Assert.assertEquals(statucode, 201);
        System.out.println(getresponse.getTime());
    }

    @Test(enabled = false)
    public void GETREQAPI() {

        /*Method 1*/
        given().
                when().
                get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").
                then().
                log().all();

        /*Method 2*/
        String URL = "http://demo.guru99.com/V4/sinkministatement.php";
        given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(URL).then().
                log().body();

        /*Method 3*/
        Response response = given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(URL);
        Assert.assertEquals(response.getStatusCode(),200);
        String Responsebody=response.asString();
        Assert.assertEquals(Responsebody.contains("Success"),true);
    }
    @Test
    public void POSTREQAPI() {
        RestAssured.baseURI = "https://reqres.in";
        JSONObject requestparam = new JSONObject();
        requestparam.put("name","Anand");
        requestparam.put("job","Manager");

        given(). body(requestparam.toJSONString())
                .header("Content-Type", "application/json")
                .post("/api/users")
                .then().statusCode(201);
    }
}
