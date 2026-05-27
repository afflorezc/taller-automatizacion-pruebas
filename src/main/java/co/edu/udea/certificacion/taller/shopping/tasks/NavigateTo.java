package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.HomePage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductsPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ShoppingCartPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CheckoutPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.PaymentPage.*;

import co.edu.udea.certificacion.taller.shopping.interactions.RemoveInteractions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CreatedAccountPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateTo implements Task{

    private static Target link;
    private static Target testField;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(link));
        actor.attemptsTo(RemoveInteractions.removeAdds());
        actor.attemptsTo(
            WaitUntil.the(
                testField,
                isVisible()
            ).forNoMoreThan(10).seconds()
        );
    }

    public static NavigateTo signupPage(){
        link = SIGN_UP_LINK;
        testField = NAME_FIELD;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo loggedInPage() {
        link = CONTINUE_BUTTON;
        testField = LOGGED_AS_TEXT;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo productsPage(){
        link = PRODUCTS_LINK;
        testField = CATEGORY_TEXT;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo shoppingCart(){
        link = CART_LINK;
        testField = SHOPPING_CART_TEXT;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo chekoutPage(){
        link = CHECKOUT_BUTTON;
        testField = CHECKOUK_TITLE_TEXT;
        return Tasks.instrumented(NavigateTo.class);
    }

    public static NavigateTo paymentPage(){
        link = PLACE_ORDER_BUTTON;
        testField = CARD_NAME_INPUT;
        return Tasks.instrumented(NavigateTo.class);
    }
}
