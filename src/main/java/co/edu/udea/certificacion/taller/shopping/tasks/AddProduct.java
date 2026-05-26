package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SelectProductPage.ADD_PRODUCT_TO_CART_BUTTON;

import co.edu.udea.certificacion.taller.shopping.interactions.AddToCart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AddProduct implements Task{

    private static WebElementFacade addButton;

    @Override
    public <T extends Actor> void performAs(T actor) {

        addButton = ADD_PRODUCT_TO_CART_BUTTON.resolveFor(actor);
        actor.attemptsTo(AddToCart.theProduct(addButton));
    }

    public static AddProduct fromProductDetailsPage(){
        return Tasks.instrumented(AddProduct.class);
    }
}
