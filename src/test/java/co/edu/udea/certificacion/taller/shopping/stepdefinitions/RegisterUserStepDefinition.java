package co.edu.udea.certificacion.taller.shopping.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RegisterUserStepDefinition {

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("I am in the Signup page")
    public void iAmInTheSignupPage() {
        // Task: to enter to sigun page
    }

    @When("I enter the signup information")
    public void iEnterTheSignupInformation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I can see a welcome message")
    public void iCanSeeAWelcomeMessage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter an existing email address")
    public void iEnterAnExistingEmailAddress() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see a message that such email is already registered")
    public void iSeeAMessageThatSuchEmailIsAlreadyRegistered() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter incomplete sigunp information")
    public void iEnterIncompleteSigunpInformation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I can see a warning in the first empty field")
    public void iCanSeeAWarningInTheFirstEmptyField() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
