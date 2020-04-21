package GOF23.Factory.AbstractFactory;

/**
 * 抽象工厂模式
 *  - 用于生产不同产品族的全部产品
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();
    }
}
