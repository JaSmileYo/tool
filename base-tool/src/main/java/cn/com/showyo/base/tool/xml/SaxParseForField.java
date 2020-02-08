package cn.com.showyo.base.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SaxParseForField {
	
	String nodeName();
	
	String attrName() default "";
	
	String dateFormat() default "";

}
