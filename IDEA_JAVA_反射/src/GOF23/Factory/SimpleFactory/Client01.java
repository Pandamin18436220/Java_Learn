package GOF23.Factory.SimpleFactory;

public class Client01 {
    /**
     * 没有工厂模式的情况下
     */
        public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();
        c1.run();
        c2.run();
    }
}
