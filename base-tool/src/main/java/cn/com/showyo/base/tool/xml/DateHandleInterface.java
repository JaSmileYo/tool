package cn.com.showyo.base.tool.xml;

import java.text.DateFormat;

/**
 * <p>设置日期格式接口</p>
 * @author 游修良
 * @date 2020年2月8日 下午4:07:52
 */
@FunctionalInterface
public interface DateHandleInterface {
	
	/**
	 * <p>设置DateFormat</p>
	 * @return
	 */
	DateFormat setDateFormat();

}
