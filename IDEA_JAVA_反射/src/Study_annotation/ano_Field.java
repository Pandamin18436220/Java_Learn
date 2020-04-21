package Study_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ano_Field {
    String columnName();
    String type();
    int length();
}
