package Server_study01;

/**
 * Create By ${潘晟凯} on S{DATE}
 */
/**
 * 反射:把java类中的各种结构(方法，属性，构造器，类名)映射成一个个java对象
 * 1.获取Class对象       //获取图纸，看结构
 *      1.对象.getClass();
 *      2.类.class;
 *推荐: 3.Class.forName("包名.类名");
 * 2.可以动态创建对象   //可以分解图纸
 *
 *
 * @author Pandamin
 *
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        /**
         * 三种方式获取class对象
         */
        //1.对象.getClass();                      类似于自己有个lphone,拆开自己看(相当于自己看图纸)
        //		lphone iphone=new lphone();
        //		Class clz = iphone.getClass();
        //2.类.class();                           类似于买通了内部经理，直接拿到了图纸
        //		clz=lphone.class;
        //3.Class.forName("包名.类名");           类似于自己知道地址，去偷图纸
        Class clz=Class.forName("Sever.basic.lphone");

        /**
         * 创建对象
         */
        //方式1:不安全
        lphone iphone2=(lphone)clz.newInstance();
        //方式2:相对安全
        //		lphone iphone2=(lphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}
class lphone{
    public lphone(){

    }
}