package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.PaymentPage.PAY_AND_CONFIRM_BUTTON;

import co.edu.udea.certificacion.taller.shopping.interactions.Delay;
import co.edu.udea.certificacion.taller.shopping.interactions.EnterTheCard;
import co.edu.udea.certificacion.taller.shopping.models.CardInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EnterCard implements Task{

    private final CardInformation cardInformation;

    public EnterCard(CardInformation cardInformation){
        this.cardInformation = cardInformation;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(NavigateTo.chekoutPage());
        actor.attemptsTo(NavigateTo.paymentPage());
        actor.attemptsTo(EnterTheCard.information(cardInformation));
        actor.attemptsTo(Click.on(PAY_AND_CONFIRM_BUTTON));
        actor.attemptsTo(Delay.betweenSteps());
    }

    public static EnterCard information(CardInformation cardInformation){
        return Tasks.instrumented(EnterCard.class, cardInformation);
    }

}
