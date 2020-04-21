package GOF23.Factory.SimpleFactory;

/**
 * 工厂模式
 *   - 实现了创建者和调用者的分离
 *   - 详细分类
 *      - 简单工厂模式
 *          -用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已有代码）
 *      - 工厂方法模式
 *          -用来生成同一等级结构中的固定产品。（支持增加任意产品）
 *      - 抽象工厂模式
 *          -用来生产不同品种的全部产品（对于增加的新产品，无能为力，支持增加产品）
 * 面向对象设计的基本原则
 *   - OCP 开闭原则： 一个软件的实体应当对扩展开放，对修改关闭
 *   - DIP 依赖倒转原则：要争对接口编程，不要争对实现编程
 *   - loD 迪米特模式：只与你直接的朋友通讯，而避免和陌生人通信
 *
 *  应用常见
 *   - JDK中Calendar的getInstance方法
 *   - JDBC中Connection对象的获取
 *   - Hibernate中SessionFactory创建Session\
 *   - spring中IOC容器创建管理bean对象
 *   - XML解析时的DocumentBuilderFactory创建解析器对象
 *   - 反射中Class对象的newInstance()
 */
public class CarFactory {
    public static Car createCar(String type){
        if("audi".equals(type)){
            return new Audi();
        }else if("Byd".equals(type)){
            return new Byd();
        }else{
            return null;
        }
    }
//    public static Car createAudi(){
//        return new Audi();
//    }
//    public static Car createByd(){
//        return new Byd();
//    }
}
