package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/checkout")
public class CheckoutPage extends PageObject{

    public static final Target CHECKOUK_TITLE_TEXT = Target.the(
        "Tittle indicating we are in Checkout page")
        .locatedBy("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]");

    public static final Target DELIVERY_ADDRES_CARD = Target.the(
        "Card with the User Delivery Address")
        .located(By.id("address_delivery"));
    
    public static final Target PLACE_ORDER_BUTTON = Target.the(
        "Place the order button")
        .locatedBy("//*[@id=\"cart_items\"]/div/div[7]/a");

}
