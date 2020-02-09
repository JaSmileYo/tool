package cn.com.showyo.base.tool.xml;

/**
 * <p>自定义文本节点解析扩展器</p>
 * @author 游修良
 * @date 2020年2月9日 下午3:16:02
 */
@FunctionalInterface
public interface ContentHandlerInterface {

	/**
	 * <p>解析文本节点，直接返回解析对象到字段</p>
	 * @param content
	 * @return
	 */
	Object hanlderContent(String content);
	
	/**
	 * <p>是否执行hanlderContent方法,默认执行</p>
	 * @return
	 */
	default boolean shouldHandler() {
		return true;
	}
	
}
