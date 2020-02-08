package cn.com.showyo.base.tool.xml;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>通过注解解析xml为java对象</p>
 * @author 游修良
 * @date 2020年2月8日 下午1:05:20
 * @param <T>输出的java对象 必须有{@link SaxParseForType}注解，且{@link SaxParseForType}的{@link SaxParseForType#nodeName()}属性不能为空
 */
public class AnnotationSaxParseHanlder<T> extends DefaultHandler {
	
	//输出的java对象
	private T returnObj;
	
	/**
	 * xml节点和java字段绑定 ,  key为xml节点或{@link #nodeAttrMap}的key值，value为javabean属性
	 */
	private Map<String, String> covertMap = new HashMap<>();
	
	/**
	 * xml节点属性绑定，key为节点名称和节点属性中间用“>”连接， value为节点名称， 
	 * {@link #nodeAttrMap}配合{@link #covertMap}可确定java字段绑定的xml节点上的指定属性
	 */
	private Map<String, String> nodeAttrMap = new HashMap<>();
	
	private Map<String, String> fieldDateFormatMap = new HashMap<>();
	
	//输出的java对象绑定的xml节点
	private String returnObjBindNode;
	
	//是否开始转换
	private boolean startHanlder = false;
	
	//文本节点值
	private String content;
	
	private DateFormat dateFormat = DATE_FORMAT;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public AnnotationSaxParseHanlder(T obj) {
		super();
		this.returnObj = obj;
	}
	
	public AnnotationSaxParseHanlder(T obj, DateHandleInterface dateHandler) {
		super();
		this.returnObj = obj;
		if(dateHandler != null) {
			this.dateFormat = dateHandler.setDateFormat();
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("======>startDocument");
		SaxParseForType classSaxParse = returnObj.getClass().getAnnotation(SaxParseForType.class);
		if(classSaxParse == null) {
			throw new SAXException("返回的对象类必须要有SaxParseForType注解");
		}
		returnObjBindNode = classSaxParse.nodeName();
		if(returnObjBindNode == null || "".equals(returnObjBindNode.trim())) {
			throw new SAXException("返回的对象类的SaxParseForType注解的nodeName属性不能为空");
		}
		Field[] fields = returnObj.getClass().getDeclaredFields();
		if(fields.length > 0) {
			SaxParseForField fieldSaxParse;
			String fieldNodeName;
			String fieldAttrName;
			String bindName;
			String fieldDateFormat;
			for (Field field : fields) {
				fieldSaxParse = field.getAnnotation(SaxParseForField.class);
				fieldNodeName = fieldSaxParse.nodeName();
				fieldAttrName = fieldSaxParse.attrName();
				fieldDateFormat = fieldSaxParse.dateFormat();
				if("".equals(fieldAttrName)) {
					bindName = fieldNodeName;
				}else {
					bindName = fieldNodeName + ">" + fieldAttrName;
					nodeAttrMap.put(bindName, fieldNodeName);
				}
				if(isNotBlankString(fieldDateFormat)) {
					fieldDateFormatMap.put(field.getName(), fieldDateFormat);
				}
				covertMap.put(bindName, field.getName());
			}
		}
		super.startDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("\nstartElemen===>localName:"+localName+",qName:"+qName);
		if(!startHanlder) {
			if(returnObjBindNode.equals(qName)) {
				startHanlder = true;
				if(nodeAttrMap.containsValue(qName)){
					setFieldValueByAttributes(qName, attributes);
				}
			}
		}else {
			if(nodeAttrMap.containsValue(qName)){
				setFieldValueByAttributes(qName, attributes);
			}
		}
		
	}
	
	/**
	 * <p>将javaBean绑定的xml的节点属性的值放入javaBean</p>
	 * @param nodeName
	 * @param attributes
	 * @throws SAXException
	 */
	private void setFieldValueByAttributes(String nodeName, Attributes attributes) throws SAXException {
		String covertMapKey;
		String fieldAttrName;
		String attrValue;
		for (Map.Entry<String, String> entry : nodeAttrMap.entrySet()) {
			if(entry.getValue().equals(nodeName)) {
				covertMapKey = entry.getKey();
				fieldAttrName = covertMapKey.split(">")[1];
				attrValue = attributes.getValue(fieldAttrName);
				setFieldValue(entry.getKey(),attrValue);
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("endElement===>localName:"+localName+",qName:"+qName+",content:"+content+"\n");
		if(startHanlder) {
			if(covertMap.containsKey(qName)){
				setFieldValue(qName,null);
			}
		}
		if(startHanlder && returnObjBindNode.equals(qName)) {
			startHanlder = false;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		System.out.println("characters===>ch:"+ch+",start:"+start+",length:"+length);
		content = new String(ch, start, length);
	}
	
	/**
	 * <p>通过反射将字段值放入javaBean</p>
	 * @param fieldKey
	 * @param fieldValue
	 * @throws SAXException
	 */
	private void setFieldValue(String fieldKey, String fieldValue) throws SAXException {
		try {
			String field = covertMap.get(fieldKey);
			if(fieldDateFormatMap.containsKey(field)) {
				dateFormat = new SimpleDateFormat(fieldDateFormatMap.get(field));
			}
			String methodName = "set" + String.valueOf(field.charAt(0)).toUpperCase() + field.substring(1);
			Class fieldType = returnObj.getClass().getDeclaredField(field).getType();
			Method md = returnObj.getClass().getMethod(methodName, fieldType);
			String value = fieldValue == null ? content : fieldValue;
			md.invoke(returnObj, getParameterValue(fieldType, value));
			dateFormat = DATE_FORMAT;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dateFormat = DATE_FORMAT;
			throw new SAXException(e);
		} 
	}
	
	/**
	 * <p>将得到的数据以Object类型返回</p>
	 * @return
	 * @throws ParseException 
	 */
	public Object getParameterValue(Class cls,String value) throws ParseException{
		String returnClass = cls.getSimpleName();
		if(returnClass.equals("int")||returnClass.equals("Integer")){
			if(isNotBlankString(value)){
				return Integer.parseInt(value);
			}else{
				if(returnClass.equals("Integer")){
					return null;
				}
				return 0;
			}
		}else if(returnClass.equals("Long")||returnClass.equals("long")){
			if(isNotBlankString(value)){
				return Long.parseLong(value);
			}else{
				if(returnClass.equals("Long")){
					return null;
				}
				return 0;
			}
		}else if(returnClass.equals("String")){
			if(isNotBlankString(value)){
				return String.valueOf(value);
			}else{
				return null;
			}
		}else if(returnClass.equals("Boolean")||returnClass.equals("boolean")){
			if(isNotBlankString(value)){
				return Boolean.parseBoolean(value);
			}else{
				if(returnClass.equals("Boolean")){
					return null;
				}
				return false;
			}
		}else if(returnClass.equals("Date")){
			if(isNotBlankString(value)){
				return dateFormat.parse(value);
			}else{
				return null;
			}
		}else if(returnClass.equals("double")||returnClass.equals("Double")){
			if(isNotBlankString(value)){
				return Double.parseDouble(value);
			}else{
				if(returnClass.equals("Double")){
					return null;
				}
				return 0;
			}
		}else if(returnClass.equals("Float")||returnClass.equals("float")){
			if(isNotBlankString(value)){
				return Float.parseFloat(value);
			}else{
				if(returnClass.equals("Float")){
					return null;
				}
				return 0;
			}
		}else if(returnClass.equals("BigInteger")){
			if(isNotBlankString(value)){
				return BigInteger.valueOf(Long.parseLong(value));
			}else{
				return null;
			}
		}
		return null;
	}
	
	private boolean isNotBlankString(String str) {
		return str == null ? false : str.trim().isEmpty() ? false : true;
	}
	
	public T getObject() {
		return this.returnObj;
	}

}
