package co.edu.udea.certificacion.taller.shopping.questions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateEmail implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        if (!BrowseTheWeb.as(actor).find(REPEATED_EMAIL_MSG).isVisible()){
            return false;
        }

        String message = BrowseTheWeb.as(actor).find(REPEATED_EMAIL_MSG).getText();
        return message.contains("Email Address already exist!");
    }

    public static ValidateEmail alreadyInUse(){
        return new ValidateEmail();
    }

}
