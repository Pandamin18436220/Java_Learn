package GOF23.facade;

public interface 工商局 {
    void checkName();  //核名
}
class 海淀区工商局 implements 工商局{

    @Override
    public void checkName() {
        System.out.println("检测名字是否冲突！");
    }
}
