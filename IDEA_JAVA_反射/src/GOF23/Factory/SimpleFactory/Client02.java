package GOF23.Factory.SimpleFactory;

/**
 * 简单工厂情况下
 */
public class Client02 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar("audi");
        Car c2 = CarFactory.createCar("Byd");

        c1.run();
        c2.run();
    }
}
