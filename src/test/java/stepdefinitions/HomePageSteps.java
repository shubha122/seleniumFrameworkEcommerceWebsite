package stepdefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("user is already logged in")
    public void user_is_already_logged_in(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        String emailId = credList.get(0).get("email");
        String password = credList.get(0).get("password");
        loginpage.lauchURL();
        homePage = loginpage.doLogin(emailId, password);
        homePage.clickOnPopUp();
    }

    @Given("click on Categories {string}")
    public void click_on_categories(String category) throws InterruptedException {
        loginpage.lauchURL();
        homePage.setSelectCategory(category);
    }

    @When("click on subcategory {string}")
    public void click_on_subcategory(String subCategory) {
        homePage.setSelectSubCategory(subCategory);
    }
    @Then("url should contains {string}")
    public void url_should_contains(String expectedLink) {
        Assert.assertTrue(homePage.verifyCurrentURL(expectedLink));
    }


}
