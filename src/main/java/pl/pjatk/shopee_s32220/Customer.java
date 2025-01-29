package pl.pjatk.shopee_s32220;

public class Customer {
    private Long id;
    private double balance;

    public Customer(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
