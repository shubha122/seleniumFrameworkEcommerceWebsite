package stepdefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("search the product {string}")
    public void search_the_product(String productName) {
        productPage.setProductDetails(productName);
    }
    @Then("count the listed product")
    public void count_the_listed_product() {

    }
    @Given("click on any product from the search list")
    public void click_on_any_product_from_the_search_list() {
        productPage.clickOnProduct();
    }

    @Given("filter the phone brand")
    public void filter_the_phone_brand() throws InterruptedException {
        productPage.filterBrandName();
    }
    @When("enter max price {string}")
    public void enter_max_price(String maxPrice) {
        productPage.setMaxPrice(maxPrice);
    }

    @When("select the cashback store")
    public void select_the_cashback_store() {
      productPage.selectCashbackStore();
    }

    @When("click on done button")
    public void click_on_done_button() {
        productPage.clickOnDoneButton();
    }

    @When("apply sort")
    public void apply_sort() throws InterruptedException {
        productPage.clickOnSortByLink();
    }

    @Then("scroll down to the page")
    public void scroll_down_to_the_page() throws InterruptedException {
        productPage.scrollDownToPage();
    }

    @Then("click on next page")
    public void click_on_next_page() throws InterruptedException {
       productPage.clickNextPage();
    }

    @Then("current page is {string}")
    public void current_page_is(String pageNo) {
        Assert.assertTrue(homePage.verifyCurrentURL(pageNo));
    }
}
