package cn.com.showyo.base.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;

/**
 * <p>java字段绑定xml</p>
 * @author 游修良
 * @date 2020年2月9日 上午11:13:07
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SaxParseForField {
	
	/**
	 * <p>java字段绑定的xml节点名称</p>
	 * @return
	 */
	String nodeName();
	
	/**
	 * <p>java字段绑定的xml节点属性名称（nodeName下的attrName属性名称）</p>
	 * @return
	 */
	String attrName() default "";
	
	/**
	 * <p>该字段的日期时间转换格式,{@link SimpleDateFormat}的pattern,例：yyyy-MM-dd HH:mm:ss</p>
	 * @return
	 */
	String dateFormat() default "";
	
	/**
	 * <p>字段为集合时的类型</p>
	 * @return
	 */
	FieldType fieldType();
	
	/**
	 * <p>字段为对象时表示字段的类型；<br/>字段为数组、集合时表示集合元素的类型</p>
	 * @return
	 */
	Class innerType() default Object.class;

}
