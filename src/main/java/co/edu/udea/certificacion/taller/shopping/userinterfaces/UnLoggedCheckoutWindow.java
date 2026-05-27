package co.edu.udea.certificacion.taller.shopping.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class UnLoggedCheckoutWindow extends PageObject {

    public static final Target REGISTER_LOGIN_TEXT = Target.the(
        "Message indicating we must register to can buy")
        .locatedBy("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[1]");

    public static final Target CONTINUE_ON_CART = Target.the(
        "Button to remain in the cart page")
        .locatedBy("//*[@id=\"checkoutModal\"]/div/div/div[3]/button");
    
    public static final Target REGISTER_LOGIN_LINK = Target.the(
        "Link to Register or login page")
        .locatedBy("//*[@id=\"checkoutModal\"]/div/div/div[3]/button");

}
