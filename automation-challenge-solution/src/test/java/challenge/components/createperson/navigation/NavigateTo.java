package challenge.components.createperson.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theCreatePersonPage() {
        return Task.where("{0} opens the Create Person form",
                Open.browserOn().the(CreatePersonPage.class));
    }
}
