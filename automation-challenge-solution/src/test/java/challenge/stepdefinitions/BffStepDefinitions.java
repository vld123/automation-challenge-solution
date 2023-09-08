package challenge.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class BffStepDefinitions {

    private JSONObject objectResponse;
    private JSONArray listResponse;
    private int actualHttpCode;

    /* The following URLs could be defined in a property file */
    private static final String pingUrl             = "http://localhost:8085/ping";
    private static final String createPersonUrl     = "http://localhost:8085/bff/persons";
    private static final String getAllPersonUrl     = "http://localhost:8085/bff/persons";
    private static final String getAllCountriesUrl  = "http://localhost:8085/bff/countries";
    private static final String deletePersonBaseUrl = "http://localhost:8085/bff/persons/";

    @When("the System sends a ping to check the Application is alive")
    public void theSystemSendsAPingToCheckTheApplicationIsAlive() {
        SerenityRest.when().get(pingUrl);
        bffResponseToObject();
    }

    @When("the front-end queries the bff to get the list of people")
    public void theFrontEndQueriesTheBffToGetTheListOfPeople() {
        SerenityRest.when().get(getAllPersonUrl);
        bffResponseToList();
    }

    @Then("it get a http code {int} and list non-empty")
    public void itGetAHttpCodeAndTheNumberOfExpectedPeopleShouldBe(int expectedHttpCode) {
        Assert.assertEquals(expectedHttpCode, actualHttpCode);
        Assert.assertFalse(listResponse.isEmpty());
    }

    @When("the front-end queries the bff to get the list of countries")
    public void theFrontEndQueryTheBffToGetTheListOfCountries() {
        SerenityRest.when().get(getAllCountriesUrl);
        bffResponseToList();
    }

    @Then("it should get a http code {int} and the number of expected countries should be {int}")
    public void itShouldGetAHttpCodeAndTheNumberOfExpectedCountriesShouldBe(int expectedHttpCode, int expectedNumberOfCountries) {
        Assert.assertEquals(expectedHttpCode, actualHttpCode);
        Assert.assertEquals(listResponse.length(), expectedNumberOfCountries);
    }

    @When("^the front-end requests to the bff to add a new person with first name \"(.*)\" last name \"(.*)\" age \"(.*)\" and country id \"(.*)\"$")
    public void theFrontEndRequestsToTheBffToAddANewPersonWithFirstNameLastNameAgeAndCountry(String firstName, String lastName, String age, String countryId) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .when()
                .body(
                        buildRequestBody(firstName, lastName, age, countryId)
                )
                .post(createPersonUrl);
        bffResponseToObject();
    }

    @When("^the front-end requests to the bff to delete the person with id \"(.*)\"$")
    public void theFrontEndRequestsToTheBffToDeleteThePersonWithID(String personId) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .when()
                .delete(deletePersonBaseUrl + personId);
        bffResponseToObject();
    }

    @Then("it should get a http code {int} and the message {string} with key {string}")
    public void itShouldGetAHttpCode(int expectedHttpCode, String expectedMessage, String messageKey) {
        Assert.assertEquals(expectedHttpCode, actualHttpCode);
        Assert.assertEquals(expectedMessage, objectResponse.get(messageKey));
    }

    @Then("it should get a http code {int}")
    public void itShouldGetAHttpCode(int expectedHttpCode) {
        Assert.assertEquals(expectedHttpCode, actualHttpCode);
    }

    @Then("it should get a http code {int} and the person {string} not null")
    public void itShouldGetAHttpCodeHTTP_CODEAndThePersonIdNotNull(int expectedHttpCode, String idkey) {
        Assert.assertEquals(expectedHttpCode, actualHttpCode);
        Assert.assertNotNull(objectResponse.get(idkey));
    }

    private void bffResponseToObject() throws JSONException {
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        objectResponse = new JSONObject(responseBody);
        actualHttpCode = SerenityRest.then().extract().statusCode();
    }

    private void bffResponseToList() {
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        listResponse = new JSONArray(responseBody);
        actualHttpCode = SerenityRest.then().extract().statusCode();
    }

    @NotNull
    private static Map<String, Object> buildRequestBody(String firstName, String lastName, String ageStr, String countryIdStr) {
        Map<String, Object> personData = new HashMap<>();

        Integer age = !ageStr.isEmpty() ? Integer.parseInt(ageStr) : null;
        Integer countryId = !countryIdStr.isEmpty() ? Integer.parseInt(countryIdStr) : null;

        personData.put("first_name", firstName);
        personData.put("last_name", lastName);
        personData.put("age", age);
        personData.put("country_id", countryId);

        return personData;
    }

}

