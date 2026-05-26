package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductAddedWindow extends PageObject {

    public static final Target CONTINUE_SHOPPING_BUTTON =
        Target.the("Boton de confirmación de añadido al carrito")
                .locatedBy("//*[@id=\"cartModal\"]/div/div/div[3]/button");

    public static final Target VIEW_CART_LINK = Target.the(
        "Link to cart in the modal window")
        .locatedBy("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
}                                   
