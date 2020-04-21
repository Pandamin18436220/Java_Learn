package GOF23.Prototype;

import java.util.Date;

/**
 * 测试原型模式（浅克隆）
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Sheep s1 = new Sheep("pandamin",new Date(1111L));
        System.out.println(s1);
        System.out.println(s1.getBirthday());

        Sheep s2 = (Sheep) s1.clone();
        System.out.println(s2);
        System.out.println(s2.getBirthday());
    }
}
