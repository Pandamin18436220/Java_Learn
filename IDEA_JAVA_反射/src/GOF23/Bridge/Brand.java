package GOF23.Bridge;

/**
 * 品牌
 */
public interface Brand {
    void sale();
}
class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}
class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售Dell电脑");
    }
}
