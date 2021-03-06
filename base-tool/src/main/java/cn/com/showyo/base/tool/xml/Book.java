package cn.com.showyo.base.tool.xml;

import java.util.Date;

/**
 * 
 * @author you_xl
 */
@SaxParseForType(nodeName = "bookstore")
public class Book {
	
	@SaxParseForField(nodeName = "book", attrName = "id", fieldType = FieldType.LONG)
	private Long id;
	
	@SaxParseForField(nodeName = "name", fieldType = FieldType.STRING)
	private String name;
	
	@SaxParseForField(nodeName = "author", attrName = "name", fieldType = FieldType.STRING)
	private String author;
	
	@ContentHandler(handler = TestContentHandler.class)
	@SaxParseForField(nodeName = "year", dateFormat = "yyyyMMdd", fieldType = FieldType.DATE)
	private Date year;
	
	@SaxParseForField(nodeName = "price", fieldType = FieldType.DOUBLE)
	private double price;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the year
	 */
	public Date getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Date year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", year=" + year + ", price=" + price + "]";
	}
	
	
}
