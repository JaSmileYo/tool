package cn.com.showyo.base.tool.xml;

import java.util.Date;

public class TestContentHandler implements ContentHandlerInterface {

	@Override
	public Object hanlderContent(String content) {
		// TODO Auto-generated method stub
		return new Date();
	}
	
	@Override
	public boolean shouldHandler() {
		// TODO Auto-generated method stub
		return ContentHandlerInterface.super.shouldHandler();
	}

}
