package co.edu.udea.certificacion.taller.shopping.stepdefinitions;

import org.openqa.selenium.WebDriver;

import co.edu.udea.certificacion.taller.shopping.models.CardInformation;
import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.questions.ActiveFieldHasValidation;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateEmpty;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateOrder;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateRegisterToBuy;
import co.edu.udea.certificacion.taller.shopping.tasks.AddProducts;
import co.edu.udea.certificacion.taller.shopping.tasks.EnterCard;
import co.edu.udea.certificacion.taller.shopping.tasks.EnterThe;
import co.edu.udea.certificacion.taller.shopping.tasks.NavigateTo;
import co.edu.udea.certificacion.taller.shopping.tasks.OpenThe;
import co.edu.udea.certificacion.taller.shopping.tasks.TryTo;

import static co.edu.udea.certificacion.taller.shopping.utils.CardInformationFromDataTable.*;
import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CheckoutStepDefinition {

    private String SESSION_VARIABLE_NAME = "USER_NAME";

    public final Actor client = Actor.named("new_client");
    @Managed(driver="chrome", uniqueSession = false)
    public WebDriver webDriver;

    @Before
    public void config(){
        client.can(BrowseTheWeb.with(webDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("new_client");
    }

    @Given("I am a logged user")
    public void iAmALoggedUserInTheCartPage() {
        client.attemptsTo(OpenThe.browser());
        client.attemptsTo(NavigateTo.signupPage());

        User user = UserBuilder.defaultUser().build();

        Serenity.setSessionVariable(SESSION_VARIABLE_NAME).to(
            user.getFirstName().toUpperCase()
        );

        client.attemptsTo(EnterThe.signupInformation(user));
        client.attemptsTo(NavigateTo.loggedInPage());

    }

    @When("I add some products to cart")
    public void iAddSomeProductsToCart() {
        client.attemptsTo(NavigateTo.productsPage());
        int items = RandomValues.randomNumber();
        client.attemptsTo(AddProducts.fromProductPage(items));
    }

    @And("I enter the card information:")
    public void iEnterTheCardInformation(DataTable cardInformation) {
        client.attemptsTo(NavigateTo.shoppingCart());
        CardInformation cardInfo = getCardInformation(cardInformation);
        cardInfo.setNameOnCard(
            Serenity.sessionVariableCalled(SESSION_VARIABLE_NAME)
        );

        client.attemptsTo(EnterCard.information(cardInfo));
    }

    @Then("I can see an order placed confirmation message")
    public void iCanSeeAnOrderPlacedConfirmationMessage() {
       GivenWhenThen.then(client)
        .should(seeThat(ValidateOrder.placedCorrectly()));
    }

    @Given("I am a not logged user")
    public void iAmANotLoggedUserInTheCartPage() {
        client.attemptsTo(OpenThe.browser());
    }

    @And("I try to checkout")
    public void iTryToCheckout() {
        client.attemptsTo(TryTo.checkout());
    }

    @Then("I see a message asking for login to can buy")
    public void iSeeAMessageAskingForLoginToCanBuy() {
        GivenWhenThen.then(client).should(
            seeThat(ValidateRegisterToBuy.message())
        );
    }

    @Given("I have not added any products to the cart")
    public void iHaveNotAddedAnyProductsToTheCart() {
        client.attemptsTo(OpenThe.browser());
    }

    @When("I select the cart")
    public void iSelectTheCart() {
        client.attemptsTo(NavigateTo.shoppingCart());
    }

    @Then("I see a message of cart empty")
    public void iSeeAMessageOfCartEmpty() {
        GivenWhenThen.then(client).should(
            seeThat(ValidateEmpty.cartMessage())
        );
    }

    @When("I enter incomplete card information:")
    public void iEnterIncompleteCardInformation(DataTable cardInformation) {
        client.attemptsTo(NavigateTo.shoppingCart());
        CardInformation cardInfo = getCardInformation(cardInformation);
        client.attemptsTo(EnterCard.information(cardInfo));
    }

    @Then("I can see a warning for the empty field")
    public void iCanSeeAWarningForTheEmptyField() {
        GivenWhenThen.then(client).should(
            seeThat(ActiveFieldHasValidation.isInvalid())
        );
    }

}
