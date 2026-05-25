package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

//https://automationexercise.com/account_created
public class CreatedAccountPage extends PageObject{

    public static final Target CREATED_ACCOUNT_TEXT= Target.the(
        "Created account message text")
        .located(
            By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
    public static final Target CONTINUE_BUTTON= Target.the(
        "Continue button after account creation")
        .located(
            By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
}
