package pl.pjatk.shopee_s32220;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartTest {
    @Test
    public void testCart() {
        //given
        Customer customer = new Customer(1L,2109387213.43);

        //when
        Cart cart = new Cart(customer);

        //then
        assertNotNull(cart.getCustomer());
        assertEquals(2109387213.43, customer.getBalance());
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    public void testAddItem() {
        //given
        Customer customer = new Customer(1L,2109387213.43);
        Cart cart = new Cart(customer);

        //when
        cart.addItem("milk");

        //then
        List<String> items = cart.getItems();
        assertEquals(1, items.size());
        assertTrue(items.contains("milk"));
    }

    @Test
    public void testAddingSameThingsMultipleTimes(){
        //given
        Customer customer = new Customer(1L,2109387213.43);
        Cart cart = new Cart(customer);

        //when
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");
        cart.addItem("milk");

        //then
        List<String> items = cart.getItems();
        assertEquals(10, items.size());
        assertEquals("milk", items.get(0));
        assertEquals("milk", items.get(1));
        assertEquals("milk", items.get(2));
        assertEquals("milk", items.get(3));
        assertEquals("milk", items.get(4));
        assertEquals("milk", items.get(5));
        assertEquals("milk", items.get(6));
        assertEquals("milk", items.get(7));
        assertEquals("milk", items.get(8));
        assertEquals("milk", items.get(9));
    }
}
