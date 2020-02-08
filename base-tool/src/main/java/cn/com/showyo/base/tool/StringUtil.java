package cn.com.showyo.base.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 
* @author 作者: 游修良
* @version 创建时间：2018年11月16日 下午4:59:50 
* 类说明  字符串相关操作
*/
public class StringUtil {
	
	/**
	 * ids分隔符  -
	 */
	public static final String idsSeparator = "-";
	
	/**
	 * ids分隔符 ,
	 */
	public static final String idsComma = ",";
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月16日 下午5:00:23 
	 * @说明 :判断输入的字符串是否是数字
	 * @param s
	 * @return
	 */
	public static boolean isNum(String s) {
        if(s != null && s.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }
	
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月16日 下午5:06:23 
	 * @说明 :判断字符串是否为空
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if(value != null && value.length()!=0) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 
	 *@author 游修良
	 *@date 2018年11月17日--上午12:11:57
	 *@instruction 方法说明：去掉空格、制表符、换页符等空白字符
	 * @param value
	 * @return
	 */
	public static String trimAll(String value) {
		value = value.replace(" ", "");
		value = value.replaceAll(" +","");
		value = value.replaceAll("\\s*", "");
		return value;
	}
	
	/**
	 * 
	 *@author 游修良
	 *@date 2018年11月17日--上午12:52:21
	 *@instruction 方法说明：判断value中是否包含str;包含返回true,否则返回false
	 * @param value母字符串
	 * @param str子字符串
	 * @return
	 */
	public static boolean hasString(String value,String str) {
		return value.indexOf(str) > -1 ? true : false;
	}
	
	/**
	 * 
	 *@author 游修良
	 *@date 2018年11月17日--上午12:58:17
	 *@instruction 方法说明：判断value中是否包含空格、制表符、换页符等空白字符;包含返回true,否则返回false
	 * @param value
	 * @return
	 */
	public static boolean hasBlank(String value) {
		//注释处代码错误why?
//		String exp = "\\s*";
//		return Pattern.matches(exp, value) ? true : false;
		String str = value;
		if(trimAll(str).equals(value)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月20日 下午5:06:19 
	 * @说明 :将用“-”连接的多个id的字符串转字符串数组
	 * @param ids
	 * @return
	 */
	public static String[] splitIdsByIdsSeparator(String ids) {
		return ids.split(idsSeparator);
	} 
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月20日 下午5:07:50 
	 * @说明 :将用“-”连接的多个id的字符串转字符串集合
	 * @param ids
	 * @return
	 */
	public static List<String> StringToListByIdsSeparator(String ids) {
		String[] idsArr = splitIdsByIdsSeparator(ids);
		ArrayList<String> arrList = new ArrayList<>(idsArr.length);
		Collections.addAll(arrList, idsArr);
		return arrList;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月8日 下午2:07:45 
	 * @说明 :将用“,”连接的多个id的字符串转字符串数组
	 * @param ids
	 * @return
	 */
	public static String[] splitIdsByIdsComma(String ids) {
		return ids.split(idsComma);
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月8日 下午2:14:50 
	 * @说明 :将用“,”连接的多个id的字符串转字符串集合
	 * @param ids
	 * @return
	 */
	public static List<String> StringToListByIdsComma(String ids) {
		String[] idsArr = splitIdsByIdsComma(ids);
		ArrayList<String> arrList = new ArrayList<>(idsArr.length);
		Collections.addAll(arrList, idsArr);
		return arrList;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月8日 下午2:23:35 
	 * @说明 :String数组转集合
	 * @param strArr
	 * @return
	 */
	public static List<String> StringArrToList(String[] strArr){
		ArrayList<String> arrList = new ArrayList<>(strArr.length);
		Collections.addAll(arrList, strArr);
		return arrList;
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月25日 上午10:50:47 
	 * @说明 :模糊查询搜索关键字时，将关键字中的%转义,防止从网页前端直接在sql中插入%
	 * @param condition
	 * @return
	 */
	public static String handleSreachSqlConditionLike(String condition) {
		int index = condition.indexOf("%");
		if((!StringUtil.isEmpty(condition)) && index > -1) {
			condition = condition.replaceAll("%", "/%");
		}
		return condition;
	}

	public static void main(String[] args) {
		System.out.println(hasBlank("admin"));
	}
}
