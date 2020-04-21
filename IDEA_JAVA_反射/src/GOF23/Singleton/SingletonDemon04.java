package GOF23.Singleton;

/**
 * 单例模式
 *     核心作用：
 *         - 保证一个类只有一个实例，并且提高一个访问该实例的全局访问点
 *
 *     常用应用场景：
 *         - window的任务管理器
 *         - window的回收站
 *         - 项目中，读取配置文件的类，一般也只有一个对象，没有必要每次使用配置文件数据，每次new一个对象区读取
 *         - 网页计算器
 *         - 日志应用
 *         - 数据库连接池
 *         - 操作系统的文件系统
 *         - Servlet编程的application
 *         - spring MVC/Struts框架中，控制器也是单例
 *
 *  单例模式的优点：
 *       - 由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的产生需要比较多的资源
 *         如读取配置，产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决
 *       - 单例模式可以在系统设置全局的访问点，优化环共享资源访问，例如可以设计一个单例类，负责所有数据表的映射处理
 *
 *       -五种单例模式实现方法
 *         - 主要：
 *             饿汉式(线程安全，调用效率高，但不能延时加载)
 *             懒汉式(线程安全，调用效率高，但能延时加载)
 *         - 主要：
 *              双重检查锁式(由于JVM底层内部模型原因，偶尔会出现问题，不建议使用)
 *              静态内部类式(线程安全，调用效率高，能延时加载)
 *              枚举单例(线程安全，调用效率高，不能延时加载)
 */

/*
 * 测试单例模式：静态内部实现方式（懒加载）
 *
 * 这种方法线程安全，调用效率高，并且实现了延时加载
 */
public class SingletonDemon04 {
    //类的初始化，不初始化这个对象（延时加载的优势）,加载类的时候是一个天然的线程安全
    private static class SingletonClassInstance{
        private static final SingletonDemon04 instance = new SingletonDemon04();
    }
    //方法没有同步，效率高
    private static SingletonDemon04 getInstance(){
        return SingletonClassInstance.instance;
    }
    private SingletonDemon04(){
    }

}
