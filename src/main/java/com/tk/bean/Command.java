package com.tk.bean;

import java.awt.HeadlessException;

import org.junit.Test;

import com.tk.util.StringUtil;

/**
 * 遥信	功能码 01	从机地址 02 地址范围 0000H-0027H  一个遥信默认读取一个，遥信的读取都是8的倍数，返回数据中的某一位代表该遥信读取的结果
 * 遥测	功能码 03	从机地址 02  地址范围 1000H-1027H  一个遥测默认读取一个
 * 从机地址固定 02
 * @author yang
 *
 */
public class Command {
	/** 指令类型，遥测还是遥信**/
	private CmdType cmdType;
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
	private String crcHighPosition;
	
	/** 返回字节数 **/
	private String byteCount;
	/** 返回字节 **/
	private String byteData;
	
	public Command(){
		init();
	}
	private void init(){
		smAddr = "02";
		functionCode = "01";
	}
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
		return crcHighPosition;
	}
	public void setHighPosition(String highPosition) {
		crcHighPosition = highPosition;
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
	
	public CmdType getCmdType() {
		return cmdType;
	}
	public void setCmdType(CmdType cmdType) {
		this.cmdType = cmdType;
	}
	public String getCrcHighPosition() {
		return crcHighPosition;
	}
	public void setCrcHighPosition(String crcHighPosition) {
		this.crcHighPosition = crcHighPosition;
	}
	
	
	/**
	 * 
	 * @desc   获取发送指令的16进制码
	 * @return
	 *
	 */
	public String cmd(){
		StringBuffer cmd = new StringBuffer();
		cmd.append(smAddr).append(functionCode).append(beginAddr)
		.append(readCount).append(crcLowPosition).append(crcHighPosition);
		return cmd.toString();		
	}
	
	/**
	 * 
	 * @desc   获取发送指令
	 * @return
	 *
	 */
	public byte[] getCmdBytes(){
		return StringUtil.hexStr2BinArr(cmd());
	}
	
	/**
     * 
     * @desc   判断是遥测还是遥信
     * @param addr
     * @return
     *
     */
    public CmdType getCmdTypeByAddr(){
    	return StringUtil.getCmdtype(this.beginAddr);
    }
    
    /**
     * 
     * @desc   获取crc字节
     * @return
     *
     */
    public byte[] getCRCByte(){
    	String crc = smAddr.concat(functionCode).concat(beginAddr).concat(readCount);
    	byte[] crcByte = StringUtil.hexStr2BinArr(crc);
    	return crcByte;
    }

    /**
     * 
     * @desc  获取返回数据中实际值 
     * @return
     *
     */
    public Integer getRealData(){
    	//返回 02 01 01 05 91CF
		//返回 02 03 02 00 6C FC 69
//    	byteData
    	String countH = byteData.substring(4, 6);
    	String dataH = byteData.substring(6, 6+Integer.parseInt(countH, 16));
    	return StringUtil.hex2Integer(dataH);
    }
    
}
