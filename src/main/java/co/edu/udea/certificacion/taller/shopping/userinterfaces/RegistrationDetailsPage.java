package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("/signup")
public class RegistrationDetailsPage extends PageObject{

    public static final Target REGISTER_TITLE = Target.the(
        "Title on account information page")
        .located(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));

    public static final Target MR_RADIO_BUTTON = Target.the(
        "Gender masculin 'Mr' button")
        .located(By.id("id_gender1"));

    public static final Target MRS_RADIO_BUTTON = Target.the(
        "Gender Femenim 'Mrs' button")
        .located(By.id("id_gender2"));

    public static final Target PASSWORD_FIELD = Target.the(
        "Signup details password field")
        .located(
            By.id("password"));

    public static final Target BIRTH_DAY_SELECT = Target.the(
        "Date of birth day select box")
        .located(By.id("days"));

    public static final Target BIRTH_MONTH_SELECT = Target.the(
        "Date of birth month select box")
        .located(By.id("months"));

    public static final Target BIRTH_YEAR_SELECT = Target.the(
        "Date of birth year select box")
        .located(By.id("years"));
    
    public static final Target NEWSLETTER_CHECKBOX = Target.the(
        "Subscription to newsletter checkbox")
        .located(By.id("newsletter"));

    public static final Target SPECIAL_OFFERS_CHECKBOX = Target.the(
        "Receive special offers checkbox")
        .located(By.id("optin"));

    public static final Target FIRST_NAME_FIELD = Target.the(
        "First name input text")
        .located(By.id("first_name"));

    public static final Target LAST_NAME_FIELD = Target.the(
        "Last name input text")
        .located(By.id("last_name"));

    public static final Target COMPANY_FIELD = Target.the(
        "Company input text")
        .located(By.id("company"));

    public static final Target ADDRESS_FIELD = Target.the(
        "Address input text")
        .located(By.id("address1"));

    public static final Target ADDRESS2_FIELD = Target.the(
        "Address2 input text")
        .located(By.id("address2"));

    public static final Target COUNTRY_SELECT = Target.the(
        "Country selection box")
        .located(By.id("country"));

    public static final Target STATE_FIELD = Target.the(
        "State field")
        .located(By.id("state"));
    
    public static final Target CITY_FIELD = Target.the(
        "City field")
        .located(By.id("city"));
    
    public static final Target ZIPCODE_FIELD = Target.the(
        "Zipcode field")
        .located(By.id("zipcode"));

    public static final Target MOBILE_NUMBER_FIELD = Target.the(
        "Mobile number field")
        .located(By.id("mobile_number"));

    public static final Target CREATE_ACCOUNT_BUTTON = Target.the(
        "Create account button")
        .located(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
    
}
