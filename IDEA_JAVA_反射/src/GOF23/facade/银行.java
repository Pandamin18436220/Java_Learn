package GOF23.facade;

public interface 银行 {
    void openAccount();
}
class 中国工商银行 implements 银行{

    @Override
    public void openAccount() {
        System.out.println("在工商银行开户");
    }
}
