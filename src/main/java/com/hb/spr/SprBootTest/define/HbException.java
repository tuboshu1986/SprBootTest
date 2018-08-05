package com.hb.spr.SprBootTest.define;

/**
 * 系统异常
 * @author Admin
 *
 */
public class HbException extends Exception {
	private static final long serialVersionUID = 1L;

	public HbException(String msg){
		super(msg);
	}
	
	public HbException(String msg, Exception e){
		super(msg, e);
	}
}
