package JAVA_Dynamic.反射;

import JAVA_Dynamic.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demon04 {
    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }
    public Map<Integer,User> test02(){
        System.out.println("test02");
        return null;
    }
    public static void main(String[] args) {
        try {
            Method m = Demon04.class.getMethod("test01",Map.class,List.class);
            //获取指定方法参数泛型信息
            Type[] t = m.getGenericParameterTypes();
            for(Type paramType :t){
                System.out.println("#"+paramType);
                if(paramType instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for(Type genericType :genericTypes) {
                        System.out.println("泛型类型：" + genericType);
                    }
                }
            }

            //获取指定方法返回泛型信息
            Method m2 = Demon04.class.getMethod("test02",null);
            Type returnType = m2.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                Type[] genericTypes =((ParameterizedType) returnType).getActualTypeArguments();
                for(Type genericType:genericTypes){
                    System.out.println("返回泛型类型："+genericType);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
