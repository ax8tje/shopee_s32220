package pl.pjatk.shopee_s32220;

import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private Storage storage;

    public ShopService(Storage storage) {
        this.storage = storage;
    }

    public boolean orderItems(Cart cart){
        double totalPrice = 0;

        for(String item: cart.getItems()){
            Product product = storage.getProducts(item);
            if(product != null){
                totalPrice += product.getPrice();
            }

        }

        Customer customer = cart.getCustomer();
        if(customer.getBalance() >= totalPrice){
            customer.setBalance(customer.getBalance() - totalPrice);
            return true;
        }else{
            return false;
        }
    }
}
