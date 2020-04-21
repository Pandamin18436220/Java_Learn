package GOF23.Factory.Factorymethod;

public class BenzFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Benz();
    }
}
