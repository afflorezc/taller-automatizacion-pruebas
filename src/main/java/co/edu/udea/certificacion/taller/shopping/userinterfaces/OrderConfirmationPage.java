package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class OrderConfirmationPage extends PageObject{

    public static final Target ORDER_PLACED_TEXT = Target.the(
        "Order placed confirmation title")
        .locatedBy("//*[@id=\"form\"]/div/div/div/h2/b");
    
    public static final Target CONTINUE_BUTTON = Target.the(
        "Button to continue shopping")
        .located(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));

}
