package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("/")
public class HomePage extends PageObject{

    public static final Target SIGN_UP_LINK = Target.the(
        "Navigation bar sign up link")
        .located(
            By.xpath(
               "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
    
    public static final Target CART_LINK = Target.the(
        "Navigation bar cart link")
        .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a)");

    public static final Target PRODUCTS_LINK = Target.the(
        "Navigation bar products link")
        .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");

    public static final Target LOGOUT_LINK = Target.the(
        "Navigation bar Logout link when logged")
        .located(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));

    public static final Target DELETE_ACCOUNT_LINK = Target.the(
        "Navigation bar delete account link when logged")
        .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");


    public static final Target LOGGED_AS_TEXT = Target.the(
        "Navigation bar Logged as text when logged")
        .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
}
