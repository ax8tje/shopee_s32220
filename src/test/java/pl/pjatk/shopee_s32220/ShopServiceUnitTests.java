package pl.pjatk.shopee_s32220;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ShopServiceUnitTests {

    @Test
    public void testOrderItems_Succes(){
        //Given
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("beer");
        //When
        boolean result = shopService.orderItems(cart);
        //Then
        assertTrue(result);
        assertEquals(3.00,customer.getBalance());
    }

    @Test
    public void testOrderItems_Fail_TooBroke(){
        //Given
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);
        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("beer");
        //When
        boolean result = shopService.orderItems(cart);
        //Then
        assertFalse(result);
        assertEquals(15.00,customer.getBalance());
    }

    @Test
    public void testOrderItems_IgnoreItemsThatDontExist(){
        //Given
        Storage storage = new Storage();
        ShopService shopService = new ShopService(storage);
        Customer customer = new Customer(1L, 15.00);
        Cart cart = new Cart(customer);
        cart.addItem("beer");
        cart.addItem("beer");
        cart.addItem("marchewka");
        //When
        boolean result = shopService.orderItems(cart);
        //Then
        assertTrue(result);
        assertEquals(5.00,customer.getBalance());
    }
}
