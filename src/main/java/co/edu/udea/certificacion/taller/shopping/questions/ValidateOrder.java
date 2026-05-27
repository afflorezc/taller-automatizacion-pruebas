package co.edu.udea.certificacion.taller.shopping.questions;

import co.edu.udea.certificacion.taller.shopping.interactions.Delay;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.OrderConfirmationPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateOrder implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Delay.betweenSteps());
        return BrowseTheWeb.as(actor).find(ORDER_PLACED_TEXT)
             .isVisible();
    }

    public static ValidateOrder placedCorrectly(){
        return new ValidateOrder();
    }

}
