package GOF23.facade;

public interface 质监局 {
    void orgCodeCerficate();//办理组织机构代码证
}
class 海淀质监局 implements 质监局{

    @Override
    public void orgCodeCerficate() {
        System.out.println("办理组织机构代码证！");
    }
}
