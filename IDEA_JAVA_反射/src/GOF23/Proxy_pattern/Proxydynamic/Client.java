package GOF23.Proxy_pattern.Proxydynamic;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        //处理器接口对象
        StarHandler handler = new StarHandler(realStar);
        //代理人
        Star proxy =(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handler);
        proxy.bookTicket();
        proxy.sing();
    }
}
