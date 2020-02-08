package cn.com.showyo.base.tool;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/** 
* @author 作者: 游修良
* @version 创建时间：2019年1月22日 下午3:01:17 
* 类说明 
*/
public class MapUtil {
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月22日 下午3:05:03 
	 * @说明 :从map中拿key对应的字符串，不存在key返回空字符串
	 * @param map
	 * @param key
	 * @return
	 */
	public static String getString(Map<String,Object> map , String key) {
		if(map == null) {
			return "";
		}
		return map.containsKey(key) ? String.valueOf(map.get(key)) : "";
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月22日 下午3:05:17 
	 * @说明 :从map中拿key对应的字符串，不存在key返回defaultStr
	 * @param map
	 * @param key
	 * @param defaultStr
	 * @return
	 */
	public static String getString(Map<String,Object> map , String key , String defaultStr) {
		if(map == null) {
			return defaultStr;
		}
		return map.containsKey(key) ? String.valueOf(map.get(key)) : defaultStr;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月22日 下午3:11:52 
	 * @说明 :从map中拿key对应的Integer值，不存在key返回null
	 * @param map
	 * @param key
	 * @return
	 */
	public static Integer getInteger(Map<String,Object> map , String key) {
		if(map == null || !map.containsKey(key) || map.get(key) == null || StringUtil.isEmpty(map.get(key).toString())) {
			return null;
		}
		return Integer.parseInt(map.get(key).toString());
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月22日 下午3:13:43 
	 * @说明 :从map中拿key对应的Integer值，不存在key返回defaultInt
	 * @param map
	 * @param key
	 * @param defaultInt
	 * @return
	 */
	public static Integer getInteger(Map<String,Object> map , String key , int defaultInt) {
		Integer rs = getInteger(map,key);
		return rs == null ? defaultInt : rs;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月23日 下午5:33:40 
	 * @说明 :校验m查询条件map中的key是否为实体类属性名，返回map中包含实体类属性名的键值对resultMap
	 * @param entity
	 * @param map
	 * @return
	 */
	public static Map<String, Object> checkMap(Class<?> entity, Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<>();
		Field[] field = entity.getDeclaredFields();
		String[] fieldName = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			fieldName[i] = field[i].getName();
		}
		for (Entry<String, Object> entry : map.entrySet()) {
			for (int i = 0; i < fieldName.length; i++) {
				String key = entry.getKey();
				if(key.equals(fieldName[i])) {
					resultMap.put(key, entry.getValue());
					break;
				}
			}
		}
		return resultMap;
	}

}
