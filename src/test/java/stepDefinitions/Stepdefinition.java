package stepDefinitions;

import page.QueryCardPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.QueryCardPage;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static page.QueryCardPage.driver;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.Driver.quitAppiumDriver;

public class Stepdefinition extends OptionsMet {
    page.QueryCardPage card=new page.QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());


    static String categoryName;
    static String popularBrandName;
    static String productName;

    @Given("User makes driver adjustments")
    public void user_makes_driver_adjustments() {
        getAppiumDriver();
    }

    @Given("User clicks the button with description {string}")
    public void user_clicks_the_button_with_description(String description) {
        ReusableMethods.wait(5);
        clickButtonByDescription(description);
    }

    @Given("Verify all the categories are visible under the Categories heading.")
    public void verify_all_the_categories_are_visible_under_the_categories_heading() throws InvalidMidiDataException {

        List<String> expectedCategoryNames = new ArrayList<>(Arrays.asList("Men", "Men Clothing", "Men T-Shirt", "Men Shorts",
                "Men Coat", "Men Suit", "Men Shoes", "Men Sneakers", "Men Classic Shoes", "Men Boots",
                "Men Casual Shoes", "Men Accessories", "Men Bags", "Men Socks", "Men Watch", "Women", "Women Clothing",
                "Woman Dresses - Skirts", "Woman T-shirt", "Woman Trousers", "Woman Coat", "Women Shoes",
                "Women Casual Shoes", "Women Classic Shoes", "Women's Boots", "Women Sneakers", "Women Accessories",
                "Women Bags", "Women Watch", "Women Jewelry", "Juniors", "Juniors Clothing", "Girl Clothes",
                "Juniors Sleepwear", "Boy Clothes", "Baby Clothes", "Juniors Shoes", "Girl Shoes",
                "Boy Shoes", "Juniors Accessories", "Juniors Bags", "Juniors Hat & Beres", "Toys"));

        List<String> actualCategoryNames = ReusableMethods.getAllCategories();

        for (int i = 0; i < actualCategoryNames.size(); i++) {
            Assert.assertEquals(expectedCategoryNames.get(i), actualCategoryNames.get(i));
        }
    }

    @Given("Select {string} category.")
    public void select_category(String assignedCategoryName) {
        categoryName = assignedCategoryName;
        ReusableMethods.selectCategory(categoryName);
    }

    @Given("Verify that the product listing for the selected category is displayed.")
    public void verify_that_the_product_listing_for_the_selected_category_is_displayed() {
        Assert.assertTrue(card.PageTitle.isDisplayed());
        Assert.assertEquals("Category names are not equals!", categoryName, card.PageTitle.getAttribute("content-desc"));

    }

    @Given("Select {string} from the category.")
    public void select_from_the_category(String expectedProductName) {
        productName = expectedProductName;
        ReusableMethods.scrollWithPartialContentDesc(expectedProductName);
    }

    @Given("Verify that the product details page for the selected product is displayed.")
    public void verify_that_the_product_details_page_for_the_selected_product_is_displayed() {

        ReusableMethods.wait(2);
        if (card.productName == null) {
            throw new AssertionError("Element 'card.productName' bulunamadı!");
        }

        String actual = card.productName.getAttribute("content-desc");

        if (actual == null) {
            throw new AssertionError("Elementin content-desc attribute'u null!");
        }

        if (productName == null) {
            throw new AssertionError("Beklenen ürün adı (productName) null!");
        }

        System.out.println("Content Description: " + actual);
        System.out.println("Expected Product Name: " + productName);

        Assert.assertTrue(actual.contains(productName));
    }
//27
    @Given("As a user muss be {string} phone and {string} password Login")
    public void as_a_user_muss_be_phone_and_password_login(String phoneNumber, String password) {
        card.Login(phoneNumber, password);
    }

    @Given("User clicks tap coordinates {int}, {int}")
    public void user_clicks_tap_coordinates(Integer x, Integer y) {
        ReusableMethods.wait(1);
        OptionsMet.touchDown(x, y);
        ReusableMethods.wait(1);
    }

    @Given("User swipe to screen coordinates {int}, {int}, {int}, {int}")
    public void user_swipe_to_screen_coordinates(Integer x, Integer y, Integer endX, Integer endY) throws InvalidMidiDataException {
        OptionsMet.swipe(x, y, endX, endY);
        ReusableMethods.wait(2);
    }

    /***US 11   **/
    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews, String price) {
        xPathElementClick(itemName, reviews, price);
    }

    @Given("Toaster is displayed")
    public void toast_is_displayed() {
        // System.out.println(card.addWishListToast.getText());
        assertTrue(card.addWishListToast.isDisplayed());
    }

    @Given("Driver turns off")
    public void driver_turns_off() {
        quitAppiumDriver();
    }


    }



