package pl.pjatk.shopee_s32220;

import  org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ShopServiceTest {

    @Test
    public void testOrderItems_Succes(){
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);

        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("beer");

        boolean result = shopService.orderItems(cart);

        assertTrue(result);
        assertEquals(3.00,customer.getBalance());
    }

    @Test
    public void testOrderItems_Fail_TooBroke(){
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);

        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("beer");

        boolean result = shopService.orderItems(cart);
        assertFalse(result);
        assertEquals(15.00,customer.getBalance());
    }

    @Test
    public void testOrderItems_IgnoreItemsThatDontExist(){
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);

        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("marchewka");

        boolean result = shopService.orderItems(cart);

        assertTrue(result);
        assertEquals(5.00,customer.getBalance());
    }

    @Test
    public void testOrderItems_EmptyBasket(){
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);

        boolean result = shopService.orderItems(cart);

        assertTrue(result);
        assertEquals(15.00,customer.getBalance());
    }
}
