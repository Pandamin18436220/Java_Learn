package JAVA_Dynamic.byteCode;

import javassist.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 测试javassist的API
 */
@SuppressWarnings("all")
public class Byte_Code02 {
    /**
     * 处理类的基本方法
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());//获取类名
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getInterfaces());//获取接口

    }

    /**
     * 测试产生新的方法
     * @throws Exception
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");

        //两种产生新方法的方法
//        CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}",cc);
        CtMethod m2 = new CtMethod(CtClass.intType,"add",
                new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m2.setModifiers(Modifier.PUBLIC);
        m2.setBody("{return $1+$2;}");//用$0表示this;$1表示方法参数的第一个参数;$2表示方法参数的第二个参数;....

        cc.addMethod(m2);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();//将cc转化成Class对象
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(200,300);
        System.out.println(result);
    }

    /**
     * 修改已有的方法信息，修改方法体的内容
     * @throws Exception
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        //插入到方法最前面
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        //插入到某行
        cm.insertAt(11,"int b =3;");
        //插入到方法最后面
        cm.insertAfter("System.out.println($1);System.out.println(\"end!!!\");");

        Class clazz = cc.toClass();//将cc转化成Class对象
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello",int.class);
        Object result = method.invoke(200,300);
        System.out.println(result);
    }

    /**
     * 属性的操作
     * @throws Exception
     */
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");

        CtField f1= new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

        cc.getDeclaredField("ename");//获取指定属性

        //增加相应set/get方法
        cc.addMethod(CtNewMethod.getter("getsalary",f1));
    }

    /**
     * 构造方法的操作
     * @throws Exception
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for(CtConstructor c:cs){
            System.out.println(c.getLongName());
        }
    }

    /**
     * 注解操作
     * @throws Exception
     */
    public static void test06() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("JAVA_Dynamic.byteCode.Emp");
        //获取所有的注解
        Object[] all = cc.getAnnotations();
        Author a =(Author)all[0];
        String name = a.name();
        int year = a.year();
        System.out.println("name:"+name+",year:"+year);
    }
    public static void main(String[] args) throws Exception {
        test04();
    }
}
