package challenge.stepdefinitions;

import challenge.components.createperson.form.CreatePersonForm;
import challenge.components.world.view.navigation.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.Map;

import static challenge.components.world.view.Scripts.collapseCountryGroup;
import static challenge.components.world.view.Scripts.getAllCountryNames;
import static challenge.components.world.view.Scripts.getCountryByKey;
import static challenge.components.world.view.Scripts.getPersonByName;
import static challenge.components.world.view.Scripts.isCountryGroupExpanded;

public class WorldStepDefinitions {

    @ParameterType(".*")
    public Actor worldActor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{worldActor} has registered in the Application with his first name {string} last name {string} age {string} and country {string}")
    public void actorHasRegisteredInTheApplicationWithHisFirstNameLastNameAgeAndCountry(Actor actor, String firstName,
                                                                                     String lastName, String age, String country) {
        actor.wasAbleTo(challenge.components.createperson.navigation.NavigateTo.theCreatePersonPage());
        actor.attemptsTo(
                CreatePersonForm.fill(firstName, lastName, age, country),
                Click.on(By.cssSelector("button[type=submit]"))
        );

        Alert alert = actor.abilityTo(BrowseTheWeb.class).getAlert();
        alert.accept();
    }

    @When("{worldActor} load the World view")
    public void actorLoadTheWorldView(Actor actor) {
        actor.wasAbleTo(NavigateTo.theWorlView());
    }

    @Then("{worldActor} should see a Group for each country {string}")
    public void actorShouldSeeAGroupForEachCountry(Actor actor, String expectedCountries) {
        String actualCountries = (String) actor.asksFor(Evaluate.javascript(getAllCountryNames).result());
        Assert.assertArrayEquals(expectedCountries.split(","), actualCountries.split(","));
    }

    @Then("{worldActor} should see the first name {string} and last name {string} in the group of {string}")
    public void actorShouldSeeTheFirstNameAndLastNameInTheGroupOf(Actor actor, String firstName, String lastName, String expectedCountry) {
        String expectedPerson = firstName + " " + lastName;
        Map<String, Object> person = (Map<String, Object>) actor.asksFor(Evaluate.javascript(getPersonByName, expectedPerson).result());
        Assert.assertNotNull(person);
        Map<String, Object> country = (Map<String, Object>) actor.asksFor(Evaluate.javascript(getCountryByKey, person.get("group")).result());
        Assert.assertNotNull(country);
        evaluatePerson(person, country, expectedPerson, expectedCountry);
    }

    @Then("{worldActor} should not see the group of {string} expanded")
    public void actorShouldNotSeeTheGroupExpanded(Actor actor, String countryGroup) {
        actor.asksFor(Evaluate.javascript(isCountryGroupExpanded, countryGroup).result());
    }

    @And("{worldActor} collapsed the Group of {string}")
    public void actorCollapsedTheGroupOf(Actor actor, String countryGroup) {
        Boolean isGroupCollapsed = (Boolean) actor.asksFor(Evaluate.javascript(collapseCountryGroup, countryGroup).result());
        Assert.assertTrue(isGroupCollapsed);
    }

    private static void evaluatePerson(Map<String, Object> person, Map<String, Object> country,
                                       String expectedPerson, String expectedCountry) {
        String actualPerson = (String) person.get("text");
        Assert.assertEquals(expectedPerson, actualPerson);
        String actualCountry = (String) country.get("text");
        Assert.assertEquals(expectedCountry, actualCountry);
    }

}

