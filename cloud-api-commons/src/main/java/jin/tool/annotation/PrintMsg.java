package jin.tool.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PrintMsg {
    int count() default 1;
    String name() default "my name is PrintMsg";
}

