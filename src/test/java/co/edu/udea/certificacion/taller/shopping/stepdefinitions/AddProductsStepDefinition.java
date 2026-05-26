package co.edu.udea.certificacion.taller.shopping.stepdefinitions;

import co.edu.udea.certificacion.taller.shopping.interactions.EnterTheQuantity;
import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.models.enums.Gender;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateElementsOnCart;
import co.edu.udea.certificacion.taller.shopping.tasks.EnterThe;
import co.edu.udea.certificacion.taller.shopping.tasks.NavigateTo;
import co.edu.udea.certificacion.taller.shopping.tasks.OpenThe;
import co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductsPage;
import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductsPage.CONTINUE_SHOPPING_BUTTON;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SelectProductPage.ADD_PRODUCT_TO_CART_BUTTON;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SelectProductPage.CONFIRM_PRODUCT_ON_CART;
import static org.hamcrest.Matchers.equalTo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AddProductsStepDefinition {

    public final Actor client = Actor.named("registed_client");
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver webDriver;

    @Before
    public void config(){
        client.can(BrowseTheWeb.with(webDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("registed_client");
    }

    @Given("I am a registed user")
    public void iAmALoggedUser() {
        client.attemptsTo(OpenThe.browser());
        client.attemptsTo(NavigateTo.signupPage());

        User user = UserBuilder.defaultUser().build();

        client.attemptsTo(EnterThe.signupInformation(user));
    }

    /*
    *
        Given I am in the products page
        When I add <quantity> different products to cart
        Then I can see the <quantity> different products in the cart
    * */

    @Given("I am in the products page")
    public void iAmInTheProductsPage() {
        client.attemptsTo(NavigateTo.productsPage());
    }

    @When("I add {int} different products to cart")
    public void iAddDifferentProductsToCart(int quantity){
        List<WebElementFacade> buttons = ProductsPage.ALL_BUY_BUTTONS.resolveAllFor(client);

        for(int i=0; i<quantity; i++) {
            WebElementFacade product = RandomValues.randomItem(buttons);

            client.attemptsTo(Click.on(product));
            client.attemptsTo(Click.on(CONTINUE_SHOPPING_BUTTON));

            buttons.remove(product);
        }
    }

    @Then("I can see the {int} different products in the cart")
    public void thenICanSeeTheQuantityDifferentProductsInTheCart(int quantity){
        client.attemptsTo(NavigateTo.shoppingCart());

        GivenWhenThen.then(client).should(seeThat(ValidateElementsOnCart.thereAreNElementsOnCar(), equalTo(quantity)));
    }
    /*
    Scenario Outline: Modify the quantity for a product
    Given I have selected a product
    When I change the quantity of a product to <quantity>
    And add the product to cart
    Then I see the product and correct quantity in the cart
*/
    @Given("I have selected a product")
    public void iHaveSelectedAProduct(){
        client.attemptsTo(NavigateTo.productsPage());

        List<WebElementFacade> buttons = ProductsPage.ALL_VIEW_PRODUCT_BUTTONS.resolveAllFor(client);

        WebElementFacade button = RandomValues.randomItem(buttons);

        client.attemptsTo(Click.on(button));
    }
    @When("I change the quantity of a product to {int}")
    public void iChangeTheQuantityOfAProductToAQuantity(int quantity){
        client.attemptsTo(EnterTheQuantity.ofProducts(quantity));
    }

    @And("add the product to cart")
    public void addTheProductToCart(){
        client.attemptsTo(Click.on(ADD_PRODUCT_TO_CART_BUTTON));
        client.attemptsTo(Click.on(CONFIRM_PRODUCT_ON_CART));
    }

    @Then("I see the product {int} times in the cart")
    public void iSeeTheProductAndCorrectQuantityInTheCart(int quantity){
        client.attemptsTo(NavigateTo.shoppingCart());

        GivenWhenThen.then(client).should(seeThat(ValidateElementsOnCart.thereAreNElementsOnCar(), equalTo(quantity)));
    }

/*
    Scenario Outline: Add multiple times the same product
    Given I am in the products page
    When I add a product to cart <quantity> times
    Then I can see the product and correct quantity in the cart
*/
    @When("I add a product to cart <quantity> times")
    public void iAddAProductToCartAQuantityOfTimes(){

    }

    @Then("I can see the product and correct quantity in the cart")
    public void iCanSeeTheProductAndCorrectQuantityInTheCart(){

    }

}
