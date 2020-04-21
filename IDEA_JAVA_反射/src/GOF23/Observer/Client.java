package GOF23.Observer;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();

        subject.registerObserver(obs1);
        subject.registerObserver(obs2);

        subject.setState(30);

        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
    }
}
