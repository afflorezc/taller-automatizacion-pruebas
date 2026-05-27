package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/payment")
public class PaymentPage extends PageObject{

    public static final Target PAYMENT_PAGE_TITLE = Target.the(
        "Payment main title page")
        .locatedBy("//*[@id='cart_items']/div/div[2]/h2"); 

    public static final Target CARD_INFORMATION_FORM = Target.the(
        "The 'programmatically hidden' card form")
        .locatedBy("//*[@id=\"payment-form\"]/div[5]/div");

    public static final Target CARD_NAME_INPUT = Target.the(
        "Card Name Input")
        .located(By.name("name_on_card"));

    public static final Target CARD_NUMBER_INPUT = Target.the(
        "The card numebr input")
        .located(By.name("card_number"));

    public static final Target CVC_CODE_INPUT = Target.the(
        "The CVC code card input")
        .located(By.name("cvc"));

    public static final Target EXPIRATION_MONTH_INPUT = Target.the(
        "Expiration Month Input")
        .located(By.name("expiry_month"));

    public static final Target EXPIRATION_YEAR_INPUT = Target.the(
        "Expiration Year Input")
        .located(By.name("expiry_year"));

    public static final Target PAY_AND_CONFIRM_BUTTON = Target.the(
        "Payment confirmation to can place the order")
        .located(By.id("submit"));

}
