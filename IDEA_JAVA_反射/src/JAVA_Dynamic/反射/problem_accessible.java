package JAVA_Dynamic.反射;

import JAVA_Dynamic.bean.User;

import java.lang.reflect.Method;

/**
 * setAccessible
 *  -启用和禁用访问安全检查的开关，值为true,则指示反射的对象在使用时应该取消Java语言访问检查。
 *   值为false则指示反射的对象应该实施java语言访问检查。并不是为true就能访问，为fals就不能访问
 *   禁止安全检查，可以提高反射的运行速度
 *
 * 反射操泛型
 *  -java采用泛型擦除的机制来引入泛型。java中的泛型仅仅是给编译器javac使用的，
 *  确保数据的安全性和安全性和免去强制类型转化的麻烦
 *  但是，一旦编译完成，所有的泛型有关的类型全部擦除
 *
 *  为了提供反射操作这些类型，java新增了
 *   - ParameterizedType
 *   - GenericArrayType
 *   - TypeVariable
 *   - wildcardType
 *  几种类型来代表不能被归于到Class类中的类型但是又和原始类型齐名的类型
 */
public class problem_accessible {
    public static void test01(){
        User u = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000L ; i++) {
            u.getUname();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法的调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }
    public static void test02() throws Exception {
//        Class clazz = Class.forName("JAVA的动态性.bean.User");
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getUname",null);
        long startTime = System.currentTimeMillis();

        for(int i= 0;i<1000000000L;i++){
            method.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态的调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }
    public static void test03() throws Exception {
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getUname",null);
        method.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for(int i= 0;i<1000000000L;i++){
            method.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态的调用，跳过安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }
}
