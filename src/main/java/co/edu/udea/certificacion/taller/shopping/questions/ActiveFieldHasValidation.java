package co.edu.udea.certificacion.taller.shopping.questions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ActiveFieldHasValidation implements Question<Boolean>{
    
     public static ActiveFieldHasValidation isInvalid() {
        return new ActiveFieldHasValidation();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String validationMessage = (String) js.executeScript(
                "return document.activeElement.validationMessage;"
        );

        Boolean isValid = (Boolean) js.executeScript(
                "return document.activeElement.checkValidity();"
        );

        return !isValid && validationMessage != null && !validationMessage.isBlank();
    }

}
