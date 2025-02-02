package GOF23.Proxy_pattern.Proxystatic;

public class Client {
    public static void main(String[] args) {
        Star real =new RealStar();
        Star proxy=new ProxyStar(real);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
