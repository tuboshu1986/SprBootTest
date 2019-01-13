package com.hb.spr.SprBootTest.define;

public class MvcMessage {
	private String code;
	private String message;
	
	public static enum MvcMsgCodes {
		add_success,add_failur,exception
	} 
	
	public static MvcMessage newMsg(MvcMsgCodes code, String msg){
		MvcMessage bean = new MvcMessage();
		bean.setCode(code.toString());
		bean.setMessage(msg);
		return bean;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
