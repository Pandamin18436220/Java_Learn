package GOF23.Singleton;

public class test {
    public static void main(String[] args) {
        SingletonDemon01 s1 = SingletonDemon01.getInstance();
        SingletonDemon01 s2 = SingletonDemon01.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(SingletonDemon05.INSTANCE==SingletonDemon05.INSTANCE);

    }


}
