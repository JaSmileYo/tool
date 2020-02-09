package cn.com.showyo.base.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>设置自定义解析xml文本节点的扩展器</p>
 * @author 游修良
 * @date 2020年2月9日 下午4:19:27
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ContentHandler {
	
	/**
	 * <p>设置自定义解析xml文本节点的扩展器</p>
	 * @return
	 */
	Class<? extends ContentHandlerInterface> handler();

}
