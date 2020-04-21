package GOF23.Proxy_pattern.Proxydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        Object object = null;
        if(method.getName().equals("sing")){
            object = method.invoke(realStar,objects);
        }
        return object;
    }
}
