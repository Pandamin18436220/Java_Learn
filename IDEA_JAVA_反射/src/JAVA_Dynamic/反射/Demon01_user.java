package JAVA_Dynamic.反射;

//压制警告方法
/**
 * 1.在Class后加泛型<?>  Class<?> clazz= Class.forName path;
 * 2.@SuppressWarnings("all")
 *
 * 获取Class类的方法
 * 1.Class.forName()
 * 2.getClas
 * 3..class
 */
@SuppressWarnings("all")
public class Demon01_user {
    public static void main(String[] args) {
        String path = "JAVA的动态性.bean.User";
        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应类的Class对象
            //类的整个结构信息会放在对应的Class对象中
            Class intclazz = int.class;
            int[] arr01 = new int[10];
            int[][] arr02 = new int[30][3];
            int[] arr03 = new int[30];
            double[] arr04 = new double[10];

            System.out.println(arr01.hashCode());
            System.out.println(arr02.hashCode());
            System.out.println(arr03.hashCode());
            System.out.println(arr04.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
