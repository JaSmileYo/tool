package cn.com.showyo.base.tool.xml;

import java.text.DateFormat;

/**
 * <p>设置日期格式扩展器接口</p>
 * @author 游修良
 * @date 2020年2月8日 下午4:07:52
 */
@FunctionalInterface
public interface DateHandleInterface {
	
	/**
	 * <p>设置DateFormat,作为xml解析时全局默认使用的格式,某个字段日期时间格式若有不同可以使用注解{@link SaxParseForField#dateFormat()}来设置具体格式</p>
	 * @return
	 */
	DateFormat setDateFormat();

}
