package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("/login")
public class SignUpLoginPage extends PageObject{
    
    public static final Target NAME_FIELD = Target.the(
        "Signup page name field")
        .located(
            By.name("name"));

    public static final Target EMAIL_FIELD = Target.the(
        "Signup page email field")
        .locatedBy("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    
    public static final Target SIGN_UP_BUTTON = Target.the(
        "Signup button")
        .located(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));

}
