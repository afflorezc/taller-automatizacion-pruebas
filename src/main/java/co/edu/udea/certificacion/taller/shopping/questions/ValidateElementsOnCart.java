package co.edu.udea.certificacion.taller.shopping.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ShoppingCartPage.CART_ELEMENTS;


public class ValidateElementsOnCart implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).findAll(CART_ELEMENTS).size();
    }
    public static ValidateElementsOnCart thereAreNElementsOnCar(){ return new ValidateElementsOnCart();}
}
