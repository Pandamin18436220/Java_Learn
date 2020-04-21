package JAVA_JVM;

/**
 * 类加载器的作用
 *  - 将class文件字节码内容加载到内存中，并将这些静态数据转化成方法区中的运行时数据结构
 *    在堆中生成一个代表这个类的java.lang.Class对象，作为方法区类数据的访问入口。
 *
 *   -类缓存
 *     标准的javaSE类加载器可以要求查找类，但一旦某个类被加载到类加载器中，它将维持加载缓存一段时间
 *     不过，JVM垃圾收集器可以回收这些Class对象
 *
 *    (树形结构)
 *   -引导类加载器(原生代码C++(底层),除了引导类不继承java.lang.ClassLoader，其他的都要继承ClassLoader)
 *     -扩展类加载器(JAVA)
 *       -应用程序加载器(JAVA)
 *          -自定义加载器(JAVA)
 *
 *    -java.lang.ClassLoader作用：
 *      - 根据一个指定的类的名称，找到或者生成对应的字节码，
 *        然后从这些字节码中定义出一个java类，即java.lang.Class类的一个实例
 *      - 除此之外，ClassLoader还负责加载Java应用所需的资源，如图像文件和配置文件等。
 *
 *     -相关方法
 *      - getParent()
 *      - loadClass
 *      - findClass
 *      - findClassLoadedClass
 *      - defineClass
 *      - java.lang.Class
 *      - resolveClass
 *
 *    代理模式
 *      - 交给其他加载器指定的类
 *     双亲委托机制
 *      - 某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父亲加载器，依次追溯到爷爷辈
 *        如果父类加载器可以完成类加载器任务，就完成，
 *        如果不能，则交个其子类加载；
 *
 *      - 保证Java核心库的类型安全
 *         - 这种机制保证不会出现用户自己能定义java.lang.Object类的情况。
 *
 *      - 双亲委托机制是代理模块的一种
 *         - 并不是所有的类加载器都采用双亲委托机制
 *           tomcat服务器类加载器也私有代理模块，所不同的是它是首先尝试加载某个类
 *           如果找不到代理给父类加载器。这与一般类加载器的顺序是相反的
 */
public class JVM类加载器 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class.path"));


    }
}
