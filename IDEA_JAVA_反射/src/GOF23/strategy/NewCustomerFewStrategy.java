package GOF23.strategy;

public class NewCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("不打折，原价");
        return standerPrice;
    }
}
