package JAVA_JVM;

public class test_FileSystem {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA_Dynamic\\动态编译");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA_Dynamic\\动态编译");
        Class<?> c =loader.loadClass("JAVA_Dynamic.动态编译.hello");
        Class<?> c2 =loader.loadClass("JAVA_Dynamic.动态编译.hello");
        Class<?> c3 =loader2.loadClass("JAVA_Dynamic.动态编译.hello");

        Class<?> c4 =loader2.loadClass("java.lang.String");

        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());     //同一个类，被不同的加载器加载，JVM也认为是相同的类

        System.out.println();
        System.out.println(c.getClassLoader());  //获取其加载器
        System.out.println(c4.getClassLoader());  //引导类加载器





    }
}
