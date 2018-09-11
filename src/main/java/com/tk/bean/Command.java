package com.tk.bean;

public class Command {
	/** **/
	/**从机地址**/
	private String smAddr;
	/**功能码**/
	private String functionCode;
	private String beginAddr;
	/** 读取个数 **/
	private String readCount;
	/** crc低位字节 **/
	private String crcLowPosition;
	/** crc高位字节 **/
	private String HighPosition;
	
	/** 返回字节数 **/
	private String byteCount;
	/** 返回字节 **/
	private String byteData;
	public String getSmAddr() {
		return smAddr;
	}
	public void setSmAddr(String smAddr) {
		this.smAddr = smAddr;
	}
	public String getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	public String getBeginAddr() {
		return beginAddr;
	}
	public void setBeginAddr(String beginAddr) {
		this.beginAddr = beginAddr;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	public String getCrcLowPosition() {
		return crcLowPosition;
	}
	public void setCrcLowPosition(String crcLowPosition) {
		this.crcLowPosition = crcLowPosition;
	}
	public String getHighPosition() {
		return HighPosition;
	}
	public void setHighPosition(String highPosition) {
		HighPosition = highPosition;
	}
	public String getByteCount() {
		return byteCount;
	}
	public void setByteCount(String byteCount) {
		this.byteCount = byteCount;
	}
	public String getByteData() {
		return byteData;
	}
	public void setByteData(String byteData) {
		this.byteData = byteData;
	}
	
}
