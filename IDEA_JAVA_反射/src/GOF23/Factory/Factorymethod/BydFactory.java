package GOF23.Factory.Factorymethod;

public class BydFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Byd();
    }
}
