package GOF23.Prototype;

import java.util.Date;

/**
 * 测试原型模式（深克隆）
 * 属性也要拷贝！！！！！
 */
public class Client02 {
    public static void main(String[] args) throws Exception {
        Date date = new Date(1111L);
        Sheep2 s1 = new Sheep2("pandamin",date);
        Sheep2 s2 = (Sheep2) s1.clone();

        System.out.println(s1);
        System.out.println(s1.getBirthday());

        date.setTime(8888L);

        System.out.println(s1);
        System.out.println(s1.getBirthday());
        System.out.println(s2.getBirthday());
    }
}
