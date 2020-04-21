package GOF23.Bridge;

public interface Computer {
    void sale();
}
class Desktop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}
class Laptop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}
class Pad implements Computer{
    @Override
    public void sale() {
        System.out.println("平板电脑");
    }
}

class LenovoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("联想台式机");
    }
}