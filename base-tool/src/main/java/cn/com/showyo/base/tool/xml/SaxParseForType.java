package cn.com.showyo.base.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>java类绑定的xml</p>
 * @author 游修良
 * @date 2020年2月9日 上午11:14:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SaxParseForType {
	
	/**
	 * <p>java类绑定的xml节点名称</p>
	 * @return
	 */
	String nodeName();

}
