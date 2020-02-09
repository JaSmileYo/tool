package cn.com.showyo.base.tool.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * <p>xml解析工具类</p>
 * @author 游修良
 * @date 2020年2月9日 上午10:35:47
 */
public class XmlUtil {
	
	private static final SAXParserFactory SAX_PARSER_FACTORY = SAXParserFactory.newInstance();
	
	private static  SAXParser parser;
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xml  xml字符串
	 * @param beanClass 
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlStringToJavaBean(String xml, Class beanClass) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(beanClass);
		parser.parse(is, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xml xml字符串
	 * @param beanClass
	 * @param dateHandler 设置日期格式扩展器接口
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlStringToJavaBean(String xml, Class beanClass, DateHandleInterface dateHandler) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(beanClass,dateHandler);
		parser.parse(is, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xml xml字符串
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlStringToJavaBean(String xml, T bean) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(bean);
		parser.parse(is, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xml xml字符串
	 * @param bean
	 * @param dateHandler 设置日期格式扩展器接口
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlStringToJavaBean(String xml, T bean, DateHandleInterface dateHandler) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(bean,dateHandler);
		parser.parse(is, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xmlUri xml文件uri
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlUriToJavaBean(String xmlUri, Class beanClass) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(beanClass);
		parser.parse(xmlUri, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xmlUri xml文件uri
	 * @param beanClass
	 * @param dateHandler 设置日期格式扩展器接口
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlUriToJavaBean(String xmlUri, Class beanClass, DateHandleInterface dateHandler) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(beanClass, dateHandler);
		parser.parse(xmlUri, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xmlUri xml文件uri
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlUriToJavaBean(String xmlUri, T bean) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(bean);
		parser.parse(xmlUri, handler);
		return (T) handler.getObject();
	}
	
	/**
	 * <p>xml解析为javabean</p>
	 * @param xmlUri xml文件uri
	 * @param bean
	 * @param dateHandler 设置日期格式扩展器接口
	 * @return
	 * @throws Exception
	 */
	public static <T>T xmlUriToJavaBean(String xmlUri, T bean, DateHandleInterface dateHandler) throws Exception {
		if(parser == null) {
			parser = SAX_PARSER_FACTORY.newSAXParser();
		}
		AnnotationSaxParseHanlder<T> handler = new AnnotationSaxParseHanlder<T>(bean,dateHandler);
		parser.parse(xmlUri, handler);
		return (T) handler.getObject();
	}
	
	public static void main(String[] args) {
		try {
			String xmlUri = "src/main/java/books.xml";
			String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
					"<bookstore>\r\n" + 
					"	<book id=\"3\">\r\n" + 
					"		<name>think in java</name>\r\n" + 
					"		<author name=\"aaa\"></author>\r\n" + 
					"		<year>20200208</year>\r\n" + 
					"		<price>100</price>\r\n" + 
					"	</book>\r\n" + 
					"</bookstore>";
			Book book;
			book = xmlUriToJavaBean(xmlUri, Book.class);
//			book = xmlUriToJavaBean(xmlUri, new Book());
//			book = xmlStringToJavaBean(xmlString, Book.class);
//			book = xmlStringToJavaBean(xmlString, new Book());
			System.out.println(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
