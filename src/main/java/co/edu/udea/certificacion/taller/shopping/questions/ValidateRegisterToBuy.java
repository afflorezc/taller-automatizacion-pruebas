package co.edu.udea.certificacion.taller.shopping.questions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.UnLoggedCheckoutWindow.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateRegisterToBuy implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
       return BrowseTheWeb.as(actor).find(REGISTER_LOGIN_TEXT)
             .isVisible() 
             && BrowseTheWeb.as(actor).find(REGISTER_LOGIN_TEXT)
                .getText().contains("Register / Login");
    }

    public static ValidateRegisterToBuy message(){
        return new ValidateRegisterToBuy();
    }

}
