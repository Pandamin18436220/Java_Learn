package GOF23.strategy;

public class NewCustomerManyStrategy implements Strategy{
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("打9折");
        return standerPrice*0.9;
    }
}
