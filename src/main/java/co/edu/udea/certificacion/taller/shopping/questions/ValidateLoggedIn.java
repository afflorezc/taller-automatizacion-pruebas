package co.edu.udea.certificacion.taller.shopping.questions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.HomePage.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateLoggedIn implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(LOGOUT_LINK)
             .isVisible() && BrowseTheWeb.as(actor).find(LOGGED_AS_TEXT)
             .isVisible();
    }

    public static ValidateLoggedIn userIsLogged(){
        return new ValidateLoggedIn();
    }

}
