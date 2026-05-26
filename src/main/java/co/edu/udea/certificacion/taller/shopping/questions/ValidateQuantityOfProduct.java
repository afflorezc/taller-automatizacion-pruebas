package co.edu.udea.certificacion.taller.shopping.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CreatedAccountPage.CREATED_ACCOUNT_TEXT;

public class ValidateQuantityOfProduct implements Question<Boolean> {
    @Override
    public int answeredBy(Actor actor) {
        //int quantity = BrowseTheWeb.as(actor).find().getText();
        return 0;
    }

    public static ValidateQuantityOfProduct inTheCart(){
        return new ValidateQuantityOfProduct();
    }
}
