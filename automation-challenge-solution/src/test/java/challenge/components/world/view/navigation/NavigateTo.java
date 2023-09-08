package challenge.components.world.view.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theWorlView() {
        return Task.where("{0} opens the World View",
                Open.browserOn().the(WorldView.class));
    }
}
