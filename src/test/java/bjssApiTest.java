import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.restAssured.services;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class bjssApiTest extends services {
    private Response response;
    int randomNumber;

    // create instance of Random class
    Random rand = new Random();


    @When("^I trigger \"([^\"]*)\" service with below postbody$")
    public void iTriggerServiceWithBelowPostbody(String endPoint, DataTable table) {
        randomNumber = rand.nextInt(1000);
        String value;


        JSONObject jsonBody = new JSONObject();

        Map<String, String> data = new HashMap<String, String>();
        for (Map<String, String> source : table.asMaps(String.class, String.class)) {
            for (String field : source.keySet()) {
                if (field.equalsIgnoreCase("NAME")) {
                    value = source.get(field) + randomNumber;
                }
                else{
                    value = source.get(field);
                }


                data.put(field, value);
            }
            jsonBody.putAll(data);
        }
        response = post(endPoint, jsonBody);

    }

    @Then("^I should see response code as (\\d+)$")
    public void iShouldSeeResponseCodeAs(int responseCode) {
        Assert.assertEquals(responseCode, response.getStatusCode());
    }

    @And("^I should see response message as \"([^\"]*)\"$")
    public void iShouldSeeResponseMessageAs(String responseMsg) {
        Assert.assertTrue(response.getStatusLine().contains(responseMsg));
    }

    @And("^I should see \"([^\"]*)\" as \"([^\"]*)\" in the response$")
    public void iShouldSeeAsInTheResponse(String keyAttribute, String keyValue) {
        String actualKeyValue;

        JsonPath jsonPathEvaluator = response.jsonPath();
        actualKeyValue = jsonPathEvaluator.get(keyAttribute);

        if (keyAttribute.equalsIgnoreCase("NAME")) {
            Assert.assertEquals(keyValue + randomNumber, actualKeyValue);
        } else {
            Assert.assertEquals(keyValue, actualKeyValue);
        }


    }

    @And("^I should see \"([^\"]*)\" is created in the response to indicate User has been created$")
    public void iShouldSeeIsCreatedInTheResponseToIndicateUserHasBeenCreated(String keyAttribute) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get(keyAttribute));
    }
}
