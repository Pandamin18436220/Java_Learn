package GOF23.decorator;

/**
 * 抽象组件
 */
public interface ICar {
    void move();
}
//ConcreteComponent具体构建角色（真实对象）真实构建
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

//Decorator装饰角色
class SuperCar implements ICar{

    protected ICar car;
    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
//ConcreteDecorator具体装饰角色
class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("天上飞！");
    }
    @Override
    public void move(){
        super.move();
        fly();
    }
}
class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim(){
        System.out.println("水上游！");
    }
    @Override
    public void move(){
        super.move();
        swim();
    }
}
class AICar extends SuperCar{

    public AICar(ICar car) {
        super(car);
    }

    public void autoMove(){
        System.out.println("自动跑！");
    }
    @Override
    public void move(){
        super.move();
        autoMove();
    }
}

