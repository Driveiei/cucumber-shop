package ku.shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) with quantity (.+) on the shelves")
    public void a_product_with_price_with_quantity_on_the_shelves(String name, double price, int quant) {
        catalog.addProduct(name, price, quant);
    }

    @When("Customer buy (.+) with quantity (.+)")
    public void customer_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
        catalog.getProduct(name).updateQuantity(quant);
    }

    @Then("a product (.+) on the shelves must remain (.+) left")
    public void a_product_on_the_shelves_must_remain_left(String name, int remain) {
        assertEquals(remain, catalog.getProduct(name).getRemain());
    }
}
