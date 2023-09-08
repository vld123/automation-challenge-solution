package challenge.components.createperson.form;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.pages.PageObject;

public class CreatePersonForm extends PageObject {
    public static Performable fill(String firstName, String lastName, String age, String country) {
        return Task.where(
                "{0} fill the form with: " + firstName + " " + lastName + " " + age + " " + country,
                Enter.theValue(firstName).into(CreatePersonFields.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CreatePersonFields.LAST_NAME_FIELD),
                Enter.theValue(age).into(CreatePersonFields.AGE_FIELD),
                CountrySelectElement.withValue(country)
        );
    }
}
