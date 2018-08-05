package com.hb.spr.SprBootTest.define;

/**
 * 与系统安全相关的异常
 * @author Admin
 *
 */
public class HbSecurityException extends HbException {
	private static final long serialVersionUID = 1L;

	public HbSecurityException(String msg){
		super(msg);
	}
	
	public HbSecurityException(String msg, Exception e){
		super(msg, e);
	}
	
}
