package co.edu.udea.certificacion.taller.shopping.stepdefinitions;

import java.time.LocalDate;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateCreatedAccount;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateLoggedIn;
import co.edu.udea.certificacion.taller.shopping.tasks.EnterThe;
import co.edu.udea.certificacion.taller.shopping.tasks.NavigateTo;
import co.edu.udea.certificacion.taller.shopping.tasks.OpenThe;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RegisterUserStepDefinition {

    public final Actor client = Actor.named("new_client");
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver webDriver;

    @Before
    public void config(){
        client.can(BrowseTheWeb.with(webDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("new_client");
    }

    @Given("I am in the Signup page")
    public void iAmInTheSignupPage() {
        client.attemptsTo(OpenThe.browser());
        client.attemptsTo(NavigateTo.signupPage());
    }

    @When("I enter the signup information:")
    public void iEnterTheSignupInformation(DataTable signupInformation) {
        
        Map<String, String> data = signupInformation.asMap();

        User user = UserBuilder.defaultUser()
                .withFirstName(data.get("firstName"))
                .withLastName(data.get("lastName"))
                .withPassword(data.get("password"))
                .withGender(Gender.valueOf(data.get("gender")))
                .withDateOfBirth(LocalDate.parse(data.get("dateOfBirth")))
                .build();

        client.attemptsTo(EnterThe.signupInformation(user));
    }

    @Then("I can see an user account created message")
    public void iCanSeeAccountCreatedMessage() {
        GivenWhenThen.then(client)
        .should(seeThat(ValidateCreatedAccount.userIsCreated()));
    }

    @And("I am logged in")
    public void iAmLoggedIn(){
        client.attemptsTo(NavigateTo.loggedInPage());
        GivenWhenThen.then(client).should(seeThat(ValidateLoggedIn.userIsLogged()));
    }

    @When("I enter an existing email address")
    public void iEnterAnExistingEmailAddress() {

    }
    @Then("I see a message that such email is already registered")
    public void iSeeAMessageThatSuchEmailIsAlreadyRegistered() {

    }

    @When("I enter incomplete sigunp information")
    public void iEnterIncompleteSigunpInformation() {

    }

    @Then("I can see a warning in the first empty field")
    public void iCanSeeAWarningInTheFirstEmptyField() {

    }

}
