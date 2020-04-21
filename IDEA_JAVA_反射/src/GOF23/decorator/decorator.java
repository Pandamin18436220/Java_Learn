package GOF23.decorator;

/**
 * 装饰模式
 *     职责：
 *       - 动态的为一个对象增加新的功能
 *       - 装饰模式时一种用于代替继承的技术，无须通过继承增加子类就能扩展对象的新功能
 *         使用对象的关联关系代替继承关系，更加灵活，同时避免类型体系的快速膨胀。
 *
 *     实现细节：
 *       - Component抽象构件角色
 *         - 真实对象和装饰对象相同的接口。
 *           这样，客户端对象就能够以与真实对象相同的方式同装饰对象互交
 *             - IO流中的InputStream,OutputStream，Reader,Writer
 *       - ConcreteComponent具体构建角色（真实对象）
 *         - io流中的FileInputStream，FileOutputStream
 *             - IO流中的FileInputStream,FileOutputStream
 *       - Decorator装饰角色
 *         - 持有一个抽象构建的引用。装饰对象接受所有客户端的请求，并把这些请求转发给真实的对象。
 *           这样，就能在真实对象调用前后增加新的功能。
 *             - 持有一个抽象构件的引用：IO流中的FilterInputStream,FilterOutputStream
 *       - ConcreteDecorator具体装饰角色
 *         - 负责给构件对象增加新的责任。
 *             - 负责给构件对象增加新的责任。IO流中的BufferedOutputStream,BufferedInputStream等。
 *
 *      开发中使用的场景：
 *       - IO中输入流和输出流的设计
 *       - Swing包中图形界面构件功能
 *       - Servlet API中提供了一个request对象的Decorator设计模式的默认实现类HttpServletRequestWrapper,
 *         HttpServletRequestWrapper,HttpServletRequestWrapper类，增加了request对象的功能
 *       - Strust2中，request,response,session对象的处理
 *
 *       总结：
 *       - 装饰模式也叫包装器模式
 *       - 装饰模式降低系统的耦合度，可以动态的增加或者删除对象的职责，并使得需要装饰的具体构建类
 *         和具体装饰类可以独立变化，以便增加新的具体构建类和具体装饰类。
 *       优点：
 *       - 扩展对象的功能，比继承更加灵活，不会导致类个数急剧增加
 *         可以对一个对象进行多次装饰，创造出不同行为的组合，得到功能更加强大的对象
 *       - 具体构建类和具体装饰类可以独立变化，用户可以根据自己增加新的具体构建子类和具体装饰子类
 *       缺点：
 *       - 易出错，调试麻烦
 *       - 产生很多小对象，大量小对象占据内存，影响性能
 *
 *       装饰模式与桥接模式
 *        - 两个模式都是为了解决多子类对象问题。但他们的诱因不一样。
 *          桥接模式对象自身游机制沿着多个维度变化，是既有部分不稳定。
 *          装饰模式是为了增加新的功能。
 *
 *
 *
 */
public class decorator {
}
