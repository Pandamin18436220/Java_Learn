package GOF23.Mediator;

public class Market implements Department{

    private Mediator m;   //持有中介者的引用

    public Market(Mediator m) {
        this.m = m;
        m.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("跑项目！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作！承接项目进度，需要奖金支持");
        m.command("finacial");
    }
}
