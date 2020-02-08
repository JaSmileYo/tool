package cn.com.showyo.base.tool;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import cn.com.showyo.base.tool.xml.AnnotationSaxParseHanlder;
import cn.com.showyo.base.tool.xml.Book;

public class AnnotationSaxParseTest {
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = sParserFactory.newSAXParser();
		
		AnnotationSaxParseHanlder<Book> handler = new AnnotationSaxParseHanlder<Book>(new Book(),()-> {
			return new SimpleDateFormat("yyyy-MM-dd");
		});
		parser.parse("src/main/java/books.xml", handler);
		Book book = handler.getObject();
		System.out.println(book);
	}

}
