package JAVA_Dynamic.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射API,获取类的信息(类的名字，属性，方法，构造器等)
 */
@SuppressWarnings("all")
public class Demon02 {
    public static void main(String[] args) {
        String path = "JAVA的动态性.bean.User";
        try {
            Class clazz = Class.forName(path);
            //获取类的名字
            System.out.println(clazz.getName());//获取包名
            System.out.println(clazz.getSimpleName());//类名
            //获取属性信息
            Field[] fields = clazz.getFields();//只能获得public的属性field
            Field[] fields1 =clazz.getDeclaredFields();//获取所有属性
            Field field = clazz.getDeclaredField("uname");
            System.out.println(fields1.length);
            for(Field temp :fields){
                System.out.println("Field:"+temp);
            }
            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m =clazz.getDeclaredMethod("getUname",null);
            Method m1 = clazz.getDeclaredMethod("setUname", String.class);
            for(Method m2:methods){
                System.out.println("方法信息："+m2);
            }
            //获取构造器信息
            Constructor[] constructors = clazz.getConstructors();//获得公开的构造器
            Constructor[] constructors1 = clazz.getDeclaredConstructors();//获得公开的构造器
            Constructor constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);//传入不同的参数信息获取不同的构造器
            for(Constructor temp:constructors){
                System.out.println("构造器："+temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
