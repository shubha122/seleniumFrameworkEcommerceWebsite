package stepdefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("click on LoginSignup button")
    public void click_on_login_signup_button() {
        loginpage.clickOnLoginSignUpButton();
    }

    @When("click on Login button")
    public void click_on_login_button() {
        loginpage.clickOnLoginButton();
    }

    @When("click on Use Email Address button")
    public void click_on_use_email_address_button() {
        loginpage.clickUseEmailAddressButton();
    }

    @Then("enter the username {string}")
    public void enter_the_username(String email) {
        loginpage.setEmail(email);
    }

    @Then("click on next button")
    public void click_on_next_button() {
        loginpage.clickNextBtn();
    }

    @Then("enter the password {string}")
    public void enter_the_password(String password) {
        loginpage.setPassword(password);
    }

    @Then("user can see {string} option now")
    public void user_can_see_logout_option(String logOut) {
        Assert.assertTrue(loginpage.logOutButtonIsAvailable(logOut));
    }

    @Then("dismiss the popup from home page")
    public void dismiss_the_popup_from_home_page() {
        homePage.clickOnPopUp();
    }
}
