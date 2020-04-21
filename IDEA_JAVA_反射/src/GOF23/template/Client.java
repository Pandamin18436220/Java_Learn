package GOF23.template;

public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm =new DrawMoney();
        btm.process();

        //匿名内部类
        new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        }.process();
    }
}
class DrawMoney extends  BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要取款");
    }
}
