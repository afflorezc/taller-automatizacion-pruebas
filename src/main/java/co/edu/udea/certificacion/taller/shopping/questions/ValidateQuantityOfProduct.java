package co.edu.udea.certificacion.taller.shopping.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CreatedAccountPage.CREATED_ACCOUNT_TEXT;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ShoppingCartPage.QUANTITY_OF_FIRST_PRODUCT;

public class ValidateQuantityOfProduct implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return Integer.parseInt(BrowseTheWeb.as(actor).find(QUANTITY_OF_FIRST_PRODUCT).getText());
    }

    public static ValidateQuantityOfProduct inTheCart(){
        return new ValidateQuantityOfProduct();
    }
}
