package GOF23.Adapter;

/**
 * 什么是适配器模式？
 *  - 将一个类的接口转换成客户希望的另外一个接口。
 *    Adapter模式使得原本由于接口不兼容而不能一起的那些类可以一起工作。
 *  - 模式中的角色
 *    - 目标接口Target:客户所期待的接口，目标可以是具体的或者抽象的类，也可以是接口。
 *    - 需要适配器的类Adaptee:需要适配的类或者适配者类
 *    - 适配器（Adapter）:通过包装一个需要适配的对象，把原接口转化成目标接口。
 */


/**
 * 适配器的两种实现方法
 * 1.继承
 */
public class Adapter extends Adpatee implements Target{

    @Override
    public void handleReg() {
        super.request();
    }
}
