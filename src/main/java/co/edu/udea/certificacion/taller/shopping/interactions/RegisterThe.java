package co.edu.udea.certificacion.taller.shopping.interactions;

import co.edu.udea.certificacion.taller.shopping.models.InputDate;
import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import static co.edu.udea.certificacion.taller.shopping.utils.DateManipulation.transformsDate;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RegisterThe implements Interaction {

    private final User user;

    public RegisterThe(User user){
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(EnterTheUserName.ofClient(
                this.user.getFirstName(),
                this.user.getEmail()
            ));
        }catch(Exception e){
            return;
        }

        actor.attemptsTo(Click.on(
            this.user.getGender() == Gender.M
                ? MR_RADIO_BUTTON
                : MRS_RADIO_BUTTON
        ));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(this.user.getPassword()).into(PASSWORD_FIELD));
        
        if(this.user.getDateOfBirth() != null){
            InputDate birthDate = transformsDate(this.user.getDateOfBirth());
            actor.attemptsTo(EnterTheBirthDate.ofUser(birthDate));
        }
            
        actor.attemptsTo(RegisterSubscriptions.forClient(
        this.user.getSignUpForNewsLetter(),
        this.user.getSpecialOffers()
        ));
        
        actor.attemptsTo(EnterTheUser.personalInformation(
            this.user.getFirstName(),
            this.user.getLastName(),
            this.user.getCompanyName()
        ));

        actor.attemptsTo(EnterTheAddress.ofTheUser(user));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Click.on(CREATE_ACCOUNT_BUTTON));

        actor.attemptsTo(RemoveInteractions.removeAdds());

    }

    public static RegisterThe client(User user){
        return Tasks.instrumented(RegisterThe.class, user);
    }

}
