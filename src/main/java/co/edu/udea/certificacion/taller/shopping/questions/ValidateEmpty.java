package co.edu.udea.certificacion.taller.shopping.questions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ShoppingCartPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateEmpty implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(EMPTY_CART_MESSAGE)
             .isVisible() 
             && BrowseTheWeb.as(actor).find(EMPTY_CART_MESSAGE)
                .getText().contains("Cart is empty!");
    }

    public static ValidateEmpty cartMessage(){
        return new ValidateEmpty();
    }

}
