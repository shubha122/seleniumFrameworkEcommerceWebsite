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

    @Then("{string} should be in the search list")
    public void should_be_in_the_search_list() {

    }

    @Given("click on any product from the search list")
    public void click_on_any_product_from_the_search_list() {
        productPage.clickOnProduct();
    }

    @Given("apply filter on category {string} and brand {string} and cashback store {string}")
    public void apply_filter_brand_cashback(String categoryFilter, String brandFilter, String storeFilter) {
        if (!categoryFilter.equals(""))
            productPage.setCategoryFilter(categoryFilter);
        if (!brandFilter.equals(""))
            productPage.setBrandFilter(brandFilter);
        if (!storeFilter.equals(""))
            productPage.setCashbackStoreFilter(storeFilter);
    }

    @When("enter min and max price {string} and {string}")
    public void enter_min_max_price(String minPrice, String maxPrice) {
        if (!minPrice.equals("") && !maxPrice.equals(""))
            productPage.setPriceInput(minPrice, maxPrice);
    }

    @When("click on done button")
    public void click_on_done_button() {
        productPage.clickOnDoneButton();
    }

    @When("apply sort {string}")
    public void apply_sort(String sortOption) {
        if (!sortOption.equals(""))
            productPage.setSortSelection(sortOption);
    }

    @Then("scroll down to the page")
    public void scroll_down_to_the_page() {
        productPage.scrollDownToPage();
    }

    @Then("click on next page")
    public void click_on_next_page() {
        productPage.clickNextPage();
    }
}
