package JAVA_JVM;

/**
 * 类加载器全过程
 *  - 为什么要研究类加载全过程？
 *     -有助于了解JVM运行过程
 *     -更深入了解java动态性，提高程序的灵活性
 *
 *  启动java类--->通过javac进行编译--->通过java启动虚拟机--->对类做加载与执行
 *
 *  类加载机制
 *   - 加载  ：将class文件字节码内容加载到内存中，
 *            并将这些静态数据转化成方法区中运行时数据结构，在堆中生成一个代表这个类的java.lang.Class对象
 *            作为方法区类数据的访问入口。这个过程需要类加载器参与
 *
 *   - 链接  ：将Java类的二进制代码合并到JVM的运行状态之中的过程
 *       ->验证 ：确保加载类的信息符号JVM规范，没有安全问题
 *       ->准备 ：正式为类变量（static变量）分配内存并设置类变量初始化阶段，这些内存都将在方法区中进行分配
 *       ->解析 ：虚拟机常量池内的符号常量替换为直接引用的过程
 *
 *   - 初始化 : 执行类构造器方法的过程。
 *        1.类构造器<clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块（static）中的语句合并产生的。
 *        2.当初始化一个类的时候，如果发现父类还没有进行初始化，则需要先发出父类的初始化
 *        3.虚拟机会保证一个类的<clinit>()方法在多线程中被正确加锁和同步
 *
 *   - 类的主动引用（一定发生类的初始化）
 *       - new一个类的对象
 *       - 调用静态成员（除了final常量）和静态常量方法
 *       - 使用java.lang.reflect包的方法对类进行反射调用
 *       - 当虚拟机启动java Hello,则一定会初始化Hello类，说白了就是先启动main方法所在的类
 *       - 当初始化一个类，如果其父类没有被初始化，则先初始化他的父类
 *
 *   - 类的被动引用（不会发送类的初始化）
 *       - 当访问一个静态域时，只有真正声明这个域的类才会被初始化
 *          - 通过子类引用父类的静态变量，不会导致类初始化
 *       - 通过数组定义类引用，不会触发此类的初始化
 *       - 引用常量不会触发此类初始化（常量在编译阶段就存入调用类的常量池中了）
 */
public class JVM类加载过程 {
    public static void main(String[] args) throws Exception {
        System.out.println("main方法");

        //主动引用
        /*
         * new一个类的对象
         */
        A a = new A();

        /*
         * 调用静态成员（除了final常量）和静态常量方法
         */
        System.out.println(A.width);

        /*
         * 使用java.lang.reflect包的方法对类进行反射调用
         */
        String path = "JAVA_JVM.JVM类加载器.A";
        Class cc = Class.forName(path);


        //被动引用
        /*
         * 引用常量不会触发此类初始化（常量在编译阶段就存入调用类的常量池中了）
         */
        System.out.println(A.MAX);
        /*
         * 通过数组定义类引用，不会触发此类的初始化
         */
        A[] as = new A[10];
        /*
         * 当访问一个静态域时，只有真正声明这个域的类才会被初始化
         *     - 通过子类引用父类的静态变量，不会导致类初始化
         */
        System.out.println(B.width);
    }
}
class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}

class A extends A_Father{
    public static  int width=100;
    static {
        System.out.println("静态初始化类A");
        width=300;
    }
    public A(){
        System.out.println("创建A类对象");
    }
}
class A_Father{
    public static  int width=100; //静态变量，静态域，field
    public static  final int MAX=100;
    static {
        System.out.println("静态初始化类A_Father");
    }
}