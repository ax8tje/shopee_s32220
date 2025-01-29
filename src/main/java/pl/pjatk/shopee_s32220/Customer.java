package pl.pjatk.shopee_s32220;

public class Customer {
    private Long id;
    private double balance;

    public Customer(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
