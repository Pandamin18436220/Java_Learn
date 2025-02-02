package GOF23.Mediator;

public class Finacial implements Department{
    private Mediator m;   //持有中介者的引用

    public Finacial(Mediator m) {
        this.m = m;
        m.register("finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作！钱太多了！，怎么花？");
    }
}
