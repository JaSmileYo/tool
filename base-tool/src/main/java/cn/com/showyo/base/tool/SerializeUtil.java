package cn.com.showyo.base.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
* @author 作者: 游修良
* @version 创建时间：2019年1月3日 下午2:34:30 
* 类说明  序列化工具类
*/
public class SerializeUtil {
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月3日 下午2:43:38 
	 * @说明 :序列化对象
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			byte[] data = bos.toByteArray();
			return data;
		} catch (Exception e) {
			System.err.printf("序列化对象异常：" ,e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2019年1月3日 下午2:48:15 
	 * @说明 :反序列化对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ObjectInputStream oos = null;
		ByteArrayInputStream bos = null;
		try {
			bos = new ByteArrayInputStream(bytes);
			oos = new ObjectInputStream(bos);
			return oos.readObject();
		} catch (Exception e) {
			System.err.printf("反序列化对象异常：" ,e);
			e.printStackTrace();
			return null;
		}
	}

}
