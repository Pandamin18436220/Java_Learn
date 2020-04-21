package GOF23.strategy;

public class OldCustomerManyStrategy implements Strategy{
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("打8折");
        return standerPrice*0.8;
    }
}
