package JAVA_Dynamic.byteCode;

import javassist.*;

import java.io.IOException;

/**
 * JAVA动态性的两种常见实现方式
 *  - 字节码操作
 *  - 反射
 *
 * 运行时操作字节码可以让我们实现如下功能
 * - 动态生成新的类
 * - 动态改变某个类的结构
 *
 * 优势：
 *  - 比反射开销小，性能高
 *  - JAVAsist性能高于反射，低于ASM
 *
 *  常见的字节码操作类库
 *  - BCEL
 *  - ASM    上面两者都是基于JVM(指令级),效率高;
 *  - CGLIB  基于ASM
 *  - Javassist  (源码级) 上面两者的性能差不多，该类库最常用
 *
 *  javassist的最外层的API和java的反射包中的API颇为相似
 *  - CtClass--->java.lang.Class
 *  - CtMethod-->java.reflect.Method
 *  - CtField--->java.lang.reflect.Field
 *
 * 目标测试javassist：
 * 1.创建一个全新的类
 * 2.使用XJAD反编译工具，将生成的class文件反编译成JAVA文件
 */
public class Byte_Code {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("JAVA_Dynamic.byteCode.Emp");

        //创建属性
        CtField f1 = CtField.make("private int empno;",cc);
        CtField f2 = CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empno=empno;this.ename=ename;}");
        cc.addConstructor(constructor);
        //将上面构造好的类写入myEmp
        cc.writeFile("E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA_Dynamic\\byteCode\\myEmp");
        System.out.println("生成类，成功！");

    }
}
