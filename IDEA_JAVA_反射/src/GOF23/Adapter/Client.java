package GOF23.Adapter;

/**
 * 相当于笔记本，至于USB接口
 */
public class Client {
    public void test1(Target t){
        t.handleReg();
    }

    public static void main(String[] args) {
        Client c = new Client();
        Adpatee a =new Adapter();
        Target t = new Adapter();

        c.test1(t);
    }
}
