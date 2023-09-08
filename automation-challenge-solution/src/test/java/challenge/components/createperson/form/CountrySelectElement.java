package challenge.components.createperson.form;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class CountrySelectElement implements Interaction {

    private final String valueToSelect;
    public CountrySelectElement(String valueToSelect) {
        this.valueToSelect = valueToSelect;
    }
    public static Performable withValue(String valueToSelect) {
        return new CountrySelectElement(valueToSelect);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.xpath("//select[@id='country']")),
                Click.on(By.xpath("//select[@id='country']/option[text()='" + valueToSelect + "']"))
        );
    }

}

