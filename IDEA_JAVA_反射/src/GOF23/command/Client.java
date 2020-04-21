package GOF23.command;

public class Client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receiver());

        Invoke i = new Invoke(c);
        i.call();

        //设计模式就是为了扩展性更强
        new Receiver().action();
    }
}
