package GOF23.strategy;

public class OldCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("打85折");
        return standerPrice*0.85;
    }
}
