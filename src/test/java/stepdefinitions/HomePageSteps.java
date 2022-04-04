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
        homePage = loginpage.doLogin(emailId, password);
        homePage.clickOnPopUp();
    }

    @Given("user select Categories as {string} and subcategory as {string}")
    public void user_select_categories_as_and_subcategory_as(String category, String subCategory) {
        homePage.setCategoryAndSubCategory(category,subCategory);
    }

    @Then("user should be on {string} page")
    public void url_should_be_on_the_page(String expectedLink) {
        Assert.assertTrue(homePage.verifyCurrentURL(expectedLink));
    }


}
