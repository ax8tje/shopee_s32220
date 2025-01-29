package pl.pjatk.shopee_s32220;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Storage {
    private List<Product> products;

    public Storage() {
        products = new ArrayList<>();
        products.add(new Product("milk", 3.50));
        products.add(new Product("beer", 5.00));
        products.add(new Product("breed", 2.00));
    }

    public Product getProducts(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
