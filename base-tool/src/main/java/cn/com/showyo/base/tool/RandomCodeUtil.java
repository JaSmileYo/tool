package cn.com.showyo.base.tool;

import java.util.UUID;

/**
 * <p>随机码工具类</p>
 * @author 游修良
 * @date 2020年2月8日 上午9:18:12
 */
public class RandomCodeUtil {
	
	private static final char[] BASE_CHAR_ARRAY = new char[] {0,1,2,3,4,5,6,7,8,9
			,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
			,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月16日 下午3:40:57 
	 * @说明 :返回随机字符串UUID不含‘-’字符
	 * @return
	 */
	public static String createUUId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 
	 * @author 游修良
	 * @date 2018年11月17日--下午9:09:03
	 * @instruction 方法说明：产生length位随机码
	 * @param size 随机码长度
	 * @return
	 */
	public static String createCode(int length) {
		if(length < 1 || length > 100) {
			throw new IllegalArgumentException("the length must be between 1 and 100");
		}
		char[] charArr = new char[length];
		int x;
		for(int i = 0 ; i < length ; i++) {
			x=(int)(Math.random()*(BASE_CHAR_ARRAY.length + 1));
			if(x < BASE_CHAR_ARRAY.length) {
				charArr[i] = BASE_CHAR_ARRAY[x];
			}else {
				i--;
			}
		}
		return String.valueOf(charArr);
	}

}
