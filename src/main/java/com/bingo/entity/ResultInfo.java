package com.bingo.entity;

import java.io.Serializable;

public class ResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3628494257292918461L;
	private String message = "";
	private String msgCode = "";
	private String msgMainBody = "";
	private boolean state;
	private Object methodResult;
	/**
	 */
	private String tradeCode = "";
	/**
	 */
	private String platformOrderCode = "";

	public void setPlatformOrderCode(String platformOrderCode) {
		this.platformOrderCode = platformOrderCode;
	}

	public ResultInfo() {

	}

	public ResultInfo(boolean state) {
		this.state = state;
		this.message = "";
	}

	public ResultInfo(boolean state, String message) {
		this.state = state;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Object getMethodResult() {
		return methodResult;
	}

	public void setMethodResult(Object methodResult) {
		this.methodResult = methodResult;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getPlatformOrderCode() {
		return platformOrderCode;
	}

	public String getMsgMainBody() {
		return msgMainBody;
	}

	public void setMsgMainBody(String msgMainBody) {
		this.msgMainBody = msgMainBody;
	}

}