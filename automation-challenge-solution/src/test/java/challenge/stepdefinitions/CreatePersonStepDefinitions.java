package challenge.stepdefinitions;

import challenge.components.createperson.form.CreatePersonForm;
import challenge.components.createperson.navigation.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class CreatePersonStepDefinitions {

    @ParameterType(".*")
    public Actor createPersonActor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{createPersonActor} is on the Create Person form")
    public void actorIsOnTheCreatePersonForm(Actor actor) {
        actor.wasAbleTo(NavigateTo.theCreatePersonPage());
    }

    @When("{createPersonActor} fill the form with first name {string} last name {string} age {string} and country {string}")
    public void actorFillTheFormWithFirstNameLastNameAgeAndCountry(Actor actor, String firstName, String lastName, String age, String country) {
        actor.attemptsTo(CreatePersonForm.fill(firstName, lastName, age, country));
        actor.attemptsTo(Click.on(By.cssSelector("button[type=submit]")));
    }

    @Then("{createPersonActor} should see a popup with legend {string}")
    public void actorShouldSeeAPopupWithLegend(Actor actor, String expectedMessage) {
        Alert alert = actor.abilityTo(BrowseTheWeb.class).getAlert();
        String actualMessage = alert.getText();
        alert.accept();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
