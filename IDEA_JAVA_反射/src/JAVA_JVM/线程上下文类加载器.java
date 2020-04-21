package JAVA_JVM;

/**
 * 线程类加载器是为了抛弃抛弃双亲委派加载链模式
 *  - 每一个线程都有一个关联的上下文类加载器，如果你使用new Thread()方法生成新的线程，
 *    新线程将继承器其父线程的上下文类加载器，如果程序堆线程上下文加载器没有任何变动的话，
 *    程序中所有的线程都使用系统类加载器作为上下文加载器
 *
 *     - Thread.currentThread().getContextClassLoader()
 *     - Thread.currentThread().setContextClassLoader()
 *
 *  TomCat服务器的类加载器机制
 *     - 为了安全需要实现自己的类加载器！
 *
 *  OSGi是面向java动态模块系统，为开发人员提高面向服务和基于组件的运行环境。
 *     - eclipse就是基于OSGi
 *     - 谁定义的谁加载
 *     -可以区了解一下Equinox  OSGI的实现
 */
public class 线程上下文类加载器 {
    public static void main(String[] args) {
        ClassLoader loader = 线程上下文类加载器.class.getClassLoader();
        System.out.println(loader);

        ClassLoader loader1 =Thread.currentThread().getContextClassLoader();
        System.out.println(loader1);

        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader(""));
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
