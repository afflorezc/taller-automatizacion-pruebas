package co.edu.udea.certificacion.taller.shopping.stepdefinitions;

import co.edu.udea.certificacion.taller.shopping.interactions.EnterTheQuantity;
import co.edu.udea.certificacion.taller.shopping.models.User;
import co.edu.udea.certificacion.taller.shopping.models.UserBuilder;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateElementsOnCart;
import co.edu.udea.certificacion.taller.shopping.questions.ValidateQuantityOfProduct;
import co.edu.udea.certificacion.taller.shopping.tasks.AddProduct;
import co.edu.udea.certificacion.taller.shopping.tasks.AddProducts;
import co.edu.udea.certificacion.taller.shopping.tasks.EnterThe;
import co.edu.udea.certificacion.taller.shopping.tasks.NavigateTo;
import co.edu.udea.certificacion.taller.shopping.tasks.OpenThe;
import co.edu.udea.certificacion.taller.shopping.tasks.SelectThe;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AddProductsStepDefinition {

    public final Actor client = Actor.named("registered_client");
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver webDriver;

    @Before
    public void config(){
        client.can(BrowseTheWeb.with(webDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("registered_client");
    }

    @Given("I am a registered user")
    public void iAmARegisteredUser() {
        client.attemptsTo(OpenThe.browser());
        client.attemptsTo(NavigateTo.signupPage());

        User user = UserBuilder.defaultUser().build();

        client.attemptsTo(EnterThe.signupInformation(user));
    }

    @Given("I am in the products page")
    public void iAmInTheProductsPage() {
        client.attemptsTo(NavigateTo.productsPage());
    }

    @When("I add {int} different products to cart")
    public void iAddDifferentProductsToCart(int quantity){
        client.attemptsTo(AddProducts.fromProductPage(quantity));
    }

    @Then("I can see the {int} different products in the cart")
    public void thenICanSeeTheQuantityDifferentProductsInTheCart(int quantity){
        client.attemptsTo(NavigateTo.shoppingCart());
        GivenWhenThen.then(client).should(seeThat(ValidateElementsOnCart.thereAreNElementsOnCar(), equalTo(quantity)));
    }

    @Given("I have selected a product")
    public void iHaveSelectedAProduct(){
        client.attemptsTo(NavigateTo.productsPage());
        client.attemptsTo(SelectThe.product());
    }

    @When("I change the quantity of a product to {int}")
    public void iChangeTheQuantityOfAProductToAQuantity(int quantity){
        client.attemptsTo(EnterTheQuantity.ofProducts(quantity));
    }

    @And("add the product to cart")
    public void addTheProductToCart(){
       client.attemptsTo(AddProduct.fromProductDetailsPage());
    }

    @Then("I see the product {int} times in the cart")
    public void iSeeTheProductAndCorrectQuantityInTheCart(int quantity){
        client.attemptsTo(NavigateTo.shoppingCart());
        GivenWhenThen.then(client).should(seeThat(ValidateQuantityOfProduct.inTheCart() , equalTo(quantity)));
    }

    @When("I add a product to cart {int} times")
    public void iAddAProductToCartAQuantityOfTimes(int quantity){
        client.attemptsTo(AddProducts.multipleTimesFromProductPage(quantity));
    }

}
