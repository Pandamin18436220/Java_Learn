package GOF23.Bridge;

/**
 * 电脑类型
 */
public class Computer02 {
    protected Brand brand;

    public Computer02(Brand brand) {
        this.brand = brand;
    }
    public void sale(){
        brand.sale();
    }
}
class Desktop2 extends Computer02{

    public Desktop2(Brand brand) {
        super(brand);
    }
    @Override
    public void sale(){
        brand.sale();
        System.out.println("销售台式机");
    }
}
class Laptop2 extends Computer02{

    public Laptop2(Brand brand) {
        super(brand);
    }
    @Override
    public void sale(){
        brand.sale();
        System.out.println("销售笔记本");
    }
}

