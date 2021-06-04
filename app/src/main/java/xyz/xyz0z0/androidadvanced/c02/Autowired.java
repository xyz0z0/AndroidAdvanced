package xyz.xyz0z0.androidadvanced.c02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Cheng
 * Date: 2021/6/1 8:28
 * Description: xyz.xyz0z0.androidadvanced.c02
 * @author Cheng
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired {
   String value();
}
