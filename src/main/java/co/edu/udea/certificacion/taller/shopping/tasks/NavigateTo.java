package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.HomePage.*;

import co.edu.udea.certificacion.taller.shopping.interactions.RemoveInteractions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CreatedAccountPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class NavigateTo implements Task{

    private static Target link;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(link));
        actor.attemptsTo(RemoveInteractions.removeAdds());
    }

    public static NavigateTo signupPage(){
        link = SIGN_UP_LINK;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo loggedInPage() {
        link = CONTINUE_BUTTON;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo productsPage(){
        link = PRODUCTS_LINK;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo shoppingCart(){
        link = CART_LINK;
        return Tasks.instrumented(NavigateTo.class);
    }

}
