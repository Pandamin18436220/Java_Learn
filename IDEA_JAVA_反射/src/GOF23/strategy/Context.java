package GOF23.strategy;

/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户调用分离，使得算法可以独立于客户端独立变化
 */
public class Context {
    private Strategy strategy;//当前采用的算法

    //通过构造器注入
    public Context(Strategy strategy){
        this.strategy =strategy;
    }
    //通过set注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void pringPrice(double s){
        System.out.println("您的报价为："+strategy.getPrice(s));
    }




    //使用spring的依赖注入功能，通过配置文件，动态注入不同策略对象，动态的切换不同算法
}
