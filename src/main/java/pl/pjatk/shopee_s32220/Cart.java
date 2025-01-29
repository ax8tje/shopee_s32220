package pl.pjatk.shopee_s32220;
import java.util.List;
import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private List<String> items = new ArrayList<>();

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(String itemName) {
        items.add(itemName);
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<String> getItems() {
        return items;
    }
}
