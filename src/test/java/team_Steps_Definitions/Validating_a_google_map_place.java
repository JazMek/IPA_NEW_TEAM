package team_Steps_Definitions;

import Generic.Location;
import Generic.Pojo;
import Generic.pojoEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Validating_a_google_map_place {

    Response response;
    RequestSpecification req ;
    ResponseSpecification resSpec;
    RequestSpecification res;
    @Given("add place payload")
    public void add_place_payload() {
        Pojo p = new Pojo();
        List<String> IbrahimList= new ArrayList<>();
        IbrahimList.add("Milina");
        IbrahimList.add("Karim");
        p.setTypes(IbrahimList);
        p.setAccuracy(50);
        p.setName("Ibrahim");
        p.setAddress("1390 moon and mars The milkyWay");
        p.setPhone_number("0000000001");
        p.setWebsite("www.IbrahimYale3abou.com");
        p.setLanguage("Marcin");
        Location loc =new Location();
        loc.setLat(400);
        loc.setLng(5000);
        p.setLocation(loc);

        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("Key","qaclick123")
                .setContentType(ContentType.JSON).build();
        res = given().log().all().spec(req)
                .body(p);
}
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String AMAR, String HTTPreq) {
//        pojoEnum  pEnum = pojoEnum.valueOf(AddPlace);
        pojoEnum  pEnum =pojoEnum.valueOf(AMAR);
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        if(HTTPreq.equalsIgnoreCase("POST")){
            response = res.when().post(pEnum.getResource());
        }
         else if(HTTPreq.equalsIgnoreCase("GET")){
            response = res.when().get(pEnum.getResource());
        }
        else if(HTTPreq.equalsIgnoreCase("DELETE")){
            response = res.when().delete(pEnum.getResource());
        }
        else if(HTTPreq.equalsIgnoreCase("PUT")){
            response = res.when().put(pEnum.getResource());

        }
        String responseString = response.asString();
        System.out.println("This is the Response ---->" +responseString);

    }
    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(200,response.getStatusCode());

    }
//    @Then("{string} in response body is {string}")
//    public void in_response_body_is(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
