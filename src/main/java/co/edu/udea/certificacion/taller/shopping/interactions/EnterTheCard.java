package co.edu.udea.certificacion.taller.shopping.interactions;

import co.edu.udea.certificacion.taller.shopping.models.CardInformation;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.PaymentPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterTheCard implements Interaction{

    private final CardInformation cardInformation;

    public EnterTheCard(CardInformation cardInformation){
        this.cardInformation = cardInformation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(
            cardInformation.getNameOnCard()).into(CARD_NAME_INPUT));
        
        actor.attemptsTo(Delay.betweenSteps());

        actor.attemptsTo(Enter.theValue(
            cardInformation.getCardNumber()).into(CARD_NUMBER_INPUT));
        
        actor.attemptsTo(Delay.betweenSteps());

        actor.attemptsTo(Enter.theValue(
            cardInformation.getCvcCode()).into(CVC_CODE_INPUT));
        
        actor.attemptsTo(Enter.theValue(
            cardInformation.getExpirationMonth()).into(EXPIRATION_MONTH_INPUT));
        
        actor.attemptsTo(Delay.betweenSteps());

        actor.attemptsTo(Enter.theValue(
            cardInformation.getExpirationYear()).into(EXPIRATION_YEAR_INPUT));
    }

    public static EnterTheCard information(CardInformation cardInformation){
        return Tasks.instrumented(EnterTheCard.class,cardInformation);
    }

}
