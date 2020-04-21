package Study_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息，模拟处理注解信息的流程
 */
public class Demon02 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Study_annotation.Student");
            //获取类的所有注解
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation a:annotations){
                System.out.println(a);
            }
            //获取类指定注解的值
            ano_table at =(ano_table)clazz.getAnnotation(ano_table.class);
            System.out.println(at.value());
            //获取类属性的注解
            Field f = clazz.getDeclaredField("studentName");
            ano_Field af = f.getAnnotation(ano_Field.class);
            System.out.println(af.columnName()+"--->"+af.type()+"--->"+af.length());
            //根据获取的表名，字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL,在数据库生成相关的表
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
