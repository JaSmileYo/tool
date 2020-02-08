package cn.com.showyo.base.tool;

import java.lang.reflect.Field;

/** 
* @author 作者: 游修良
* @version 创建时间：2019年3月6日 上午9：26：23
* 类说明  反射工具类
*/
public class ReflectUtil {
	
	/**
	 * @author 作者: 游修良
	 * @version 创建时间：2019年3月6日 上午9：51：56
	 * 		获取指定类的指定属性的类型
	 * @param clazz
	 * @param name
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static Class<?> getClassNameByClassFieldName(Class<?> clazz, String fieldName) {
		try {
			Field aimField = clazz.getDeclaredField(fieldName);
			return aimField.getType();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
