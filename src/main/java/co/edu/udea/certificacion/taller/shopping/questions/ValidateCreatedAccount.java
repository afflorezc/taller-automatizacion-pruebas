package co.edu.udea.certificacion.taller.shopping.questions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.CreatedAccountPage.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateCreatedAccount implements Question<Boolean>{

    private final String ACCOUNT_CREATED_TITLE = "ACCOUNT CREATED";
    @Override
    public Boolean answeredBy(Actor actor) {
        String message = BrowseTheWeb.as(actor).find(CREATED_ACCOUNT_TEXT).getText();
        return message.contains(ACCOUNT_CREATED_TITLE);
    }

    public static ValidateCreatedAccount userIsCreated(){
        return new ValidateCreatedAccount();
    }

}
