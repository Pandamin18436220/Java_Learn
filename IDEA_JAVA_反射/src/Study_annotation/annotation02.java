package Study_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解的作用就是负责注解其他注解。
 * Java定义了4个标准的meta-annotation类型
 *   - target     描述注解的使用范围
 *   - retention  表示需要在什么级别保存该注释信息 用于描述注释的生命周期
 */
@Target(value= ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface annotation02 {
    ElementType[] value();
}
