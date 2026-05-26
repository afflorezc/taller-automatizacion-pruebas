package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SelectProductPage.*;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewProduct implements Interaction{

    private final WebElementFacade button;

    public ViewProduct(WebElementFacade button){
        this.button = button;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(button));
        actor.attemptsTo(RemoveInteractions.removeAdds());
        actor.attemptsTo(
            WaitUntil.the(
                PRODUCT_QUANTITY_INPUT,
                isVisible()
            ).forNoMoreThan(10).seconds()
        );
    }

    public static ViewProduct details(WebElementFacade button){
        return Tasks.instrumented(ViewProduct.class, button);
    }

}
