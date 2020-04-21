package JAVA_Dynamic.反射;

import JAVA_Dynamic.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demon03 {
    public static void main(String[] args) {
        String path = "JAVA的动态性.bean.User";
        Class clazz;
        {
            try {
                clazz = Class.forName(path);
                //通过反射API调用构造方法，创建对象
                User u =(User)clazz.newInstance();//其实是调用了User的无参构造方法
                System.out.println(u);

                Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
                User u2 = c.newInstance(1001,18,"pandamin");
                System.out.println(u2.getUname());

                //通过反射API调用普通方法
                User u3 =(User)clazz.newInstance();
                //u3.setUname("pandamin");
                Method method = clazz.getDeclaredMethod("setUname", String.class);
                method.invoke(u3,"pandmain");
                System.out.println(u3.getUname());

                //通过反射API调用普通属性
                User u4 =(User)clazz.newInstance();
                //u4.setId(1);
                Field field = clazz.getDeclaredField("id");
                //由于其是私有的，通过调用setAccessible(true)  不要进行安全检测了
                field.setAccessible(true);
                field.set(u4,1);                 //通过反射设置属性
                System.out.println(u4.getId());//正常调用
                System.out.println(field.get(u4));//通过反射获取属性
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
