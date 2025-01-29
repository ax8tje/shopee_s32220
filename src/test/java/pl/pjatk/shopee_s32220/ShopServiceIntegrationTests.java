package pl.pjatk.shopee_s32220;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShopServiceIntegrationTests {
    @Autowired
    private ShopService shopService;


    @Test
    public void testOrderItems_SuccesfulOrder() {
        Customer customer = new Customer(1L,1000.00);
        Cart cart = new Cart(customer);
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("breed");
        cart.addItem("apple");

        boolean result = shopService.orderItems(cart);

        assertTrue(result);
    }

    @Test
    public void testOrderItems_TooBroke() {
        Customer customer = new Customer(1L,10.00);
        Cart cart = new Cart(customer);
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("breed");
        cart.addItem("apple");

        boolean result = shopService.orderItems(cart);

        assertFalse(result);
    }
}
