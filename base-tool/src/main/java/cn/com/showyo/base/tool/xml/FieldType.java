package cn.com.showyo.base.tool.xml;

import java.util.Date;

public enum FieldType {
	
	/**
	 * <p>数据类型 int 或 {@link Integer}</p>
	 */
	INT,
	/**
	 * <p>数据类型 double 或 {@link Double}</p>
	 */
	DOUBLE,
	/**
	 * <p>数据类型 float 或 {@link Float}</p>
	 */
	FLOAT,
	/**
	 * <p>数据类型 long 或 {@link Long}</p>
	 */
	LONG,
	/**
	 * <p>数据类型 char 或 {@link Character}</p>
	 */
	CHAR,
	/**
	 * <p>数据类型 byte 或 {@link Byte}</p>
	 */
	BYTE,
	/**
	 * <p>数据类型 boolean 或 {@link Boolean}</p>
	 */
	BOOLEAN,
	/**
	 * <p>数据类型 short 或 {@link Short}</p>
	 */
	SHORT,
	/**
	 * <p>{@link String}类型</p>
	 */
	STRING,
	/**
	 * <p>{@link Date}类型</p>
	 */
	DATE,
	/**
	 * <p>对象类型</p>
	 */
	OBJECT,
	/**
	 * <p>数组类型</p>
	 */
	ARRAY,
	/**
	 * <p>ArrayList集合类型</p>
	 */
	ARRAYLIST;

}
