package co.edu.udea.certificacion.taller.shopping.interactions;

import co.edu.udea.certificacion.taller.shopping.models.InputDate;
import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import static co.edu.udea.certificacion.taller.shopping.utils.DateManipulation.transformsDate;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class RegisterThe implements Interaction {

    private final User user;

    public RegisterThe(User user){
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(this.user.getFirstName()).into(NAME_FIELD));
        actor.attemptsTo(Enter.theValue(this.user.getEmail()).into(EMAIL_FIELD));
        actor.attemptsTo(Click.on(SIGN_UP_BUTTON));

        WaitUntil.the(
            PASSWORD_FIELD, 
            isVisible()
        ).forNoMoreThan(10).seconds();

        actor.attemptsTo(Click.on(
            this.user.getGender() == Gender.M
                ? MR_RADIO_BUTTON
                : MRS_RADIO_BUTTON
        ));
        
        actor.attemptsTo(Enter.theValue(this.user.getPassword()).into(PASSWORD_FIELD));
        
        InputDate birthDate = transformsDate(this.user.getDateOfBirth());
        SelectFromOptions.byVisibleText(Integer.toString(birthDate.getMonthDay()))
                         .from(BIRTH_DAY_SELECT);

        SelectFromOptions.byVisibleText(birthDate.getMonthName())
                         .from(BIRTH_MONTH_SELECT);

        SelectFromOptions.byVisibleText(Integer.toString(birthDate.getYear()))
                         .from(BIRTH_YEAR_SELECT);
        
        if (this.user.getSignUpForNewsLetter()){
            actor.attemptsTo(Click.on(NEWSLETTER_CHECKBOX));
        }

        if (this.user.getSpecialOffers()){
            actor.attemptsTo(Click.on(SPECIAL_OFFERS_CHECKBOX));
        }

        actor.attemptsTo(Enter.theValue(
            this.user.getFirstName())
            .into(FIRST_NAME_FIELD));

        actor.attemptsTo(Enter.theValue(
            this.user.getLastName())
            .into(LAST_NAME_FIELD));

        actor.attemptsTo(Enter.theValue(
            this.user.getCompanyName())
            .into(COMPANY_FIELD));

        actor.attemptsTo(Enter.theValue(
            this.user.getAddress())
            .into(ADDRESS_FIELD));
        actor.attemptsTo(Enter.theValue(
            this.user.getAddress2())
            .into(ADDRESS2_FIELD));
        
        SelectFromOptions.byVisibleText(this.user.getLocationData().getCountry())
                         .from(COUNTRY_SELECT);

        actor.attemptsTo(Enter.theValue(
            this.user.getLocationData().getState())
            .into(STATE_FIELD));
        
        actor.attemptsTo(Enter.theValue(
            this.user.getLocationData().getCity())
            .into(CITY_FIELD));

        actor.attemptsTo(Enter.theValue(
            this.user.getZipCode())
            .into(ZIPCODE_FIELD));

        actor.attemptsTo(Enter.theValue(
            this.user.getMobileNumber())
            .into(MOBILE_NUMBER_FIELD));

        actor.attemptsTo(Click.on(CREATE_ACCOUNT_BUTTON));
    }

    public static RegisterThe client(User user){
        return Tasks.instrumented(RegisterThe.class, user);
    }

}
