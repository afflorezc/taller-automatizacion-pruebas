package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class RegisterSubscriptions implements Interaction {

    private final Boolean signUpForNewsLetter;
    private final Boolean specialOffers;

    public RegisterSubscriptions(Boolean signUpForNewsLetter, Boolean specialOffers){
        this.signUpForNewsLetter = signUpForNewsLetter;
        this.specialOffers = specialOffers;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (this.signUpForNewsLetter){
            actor.attemptsTo(Delay.betweenSteps());
            actor.attemptsTo(Click.on(NEWSLETTER_CHECKBOX));
        }

        if (this.specialOffers){
            actor.attemptsTo(Delay.betweenSteps());
            actor.attemptsTo(Click.on(SPECIAL_OFFERS_CHECKBOX));
        }
    }

    public static RegisterSubscriptions forClient(Boolean signUpForNewsLetter, Boolean specialOffers){
        return Tasks.instrumented(RegisterSubscriptions.class,signUpForNewsLetter,specialOffers);
    }

}
