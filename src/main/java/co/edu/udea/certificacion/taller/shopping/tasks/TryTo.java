package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ShoppingCartPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.UnLoggedCheckoutWindow.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.edu.udea.certificacion.taller.shopping.interactions.Delay;

public class TryTo implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(NavigateTo.shoppingCart()); 
       actor.attemptsTo(Click.on(CHECKOUT_BUTTON));
       actor.attemptsTo(Delay.betweenSteps());
       actor.attemptsTo(
            WaitUntil.the(
                REGISTER_LOGIN_TEXT,
                isVisible()
            ).forNoMoreThan(10).seconds()
       );
    }

    public static TryTo checkout(){
        return Tasks.instrumented(TryTo.class);
    }

}
