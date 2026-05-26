package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductAddedWindow.*;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Interaction{

    private final WebElementFacade product;

    public AddToCart(WebElementFacade product){
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(product));

        actor.attemptsTo(
            WaitUntil.the(
                CONTINUE_SHOPPING_BUTTON,
                isVisible()
            ).forNoMoreThan(10).seconds()
        );
        
        actor.attemptsTo(Click.on(CONTINUE_SHOPPING_BUTTON));
        actor.attemptsTo(RemoveInteractions.removeAdds());
    }

    public static AddToCart theProduct(WebElementFacade product){
        return Tasks.instrumented(AddToCart.class, product);
    }

}
