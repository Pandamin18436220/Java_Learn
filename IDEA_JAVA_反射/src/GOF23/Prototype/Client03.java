package GOF23.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 测试原型模式（深克隆）
 * 另一种方法：使用序列化和反序列化
 */
public class Client03 {
    public static void main(String[] args) throws Exception {
        Date date = new Date(1111L);
        Sheep s1 = new Sheep("pandamin",date);
        System.out.println(s1);
        System.out.println(s1.getBirthday());

//        Sheep s2 = (Sheep) s1.clone();
        //使用序列化实现
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        Sheep s2 = (Sheep) ois.readObject();//克隆对象

        System.out.println("修改属性");
        date.setTime(9999L);
        System.out.println(s1);
        System.out.println(s1.getBirthday());
        System.out.println(s2.getBirthday());
    }
}
