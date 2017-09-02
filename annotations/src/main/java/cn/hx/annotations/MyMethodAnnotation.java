package cn.hx.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by huangx on 2017/9/1.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MyMethodAnnotation {
    String name() default "";
}
