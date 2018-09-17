package com.tk.bean;

import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

import com.tk.util.Crc32;
import com.tk.util.ModbusCRC16;
import com.tk.util.StringUtil;

/**
 * 命令信息，由次信息可以得到命令{@link Command}
 * @author yang
 *
 */
public class CommandInfo {

	/** 下位机前面固定前缀 **/
	private static final String prefixRegex = "4WUB|4WB";
	/** 命令编号 **/
	private String sn;
	/** 下位机地址 (如4WUB8332)**/
	private String plAddr;
	/** 触屏变量名 (如系数44)**/
	private String sname;
	/** 单位 **/
	private String unit;
	/** 值与对应变量名称 name(变量名称, 如3.3kv) value(值,如13107)**/
	private List<Map<String, String>> desc;
	
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getPlAddr() {
		return plAddr;
	}
	public void setPlAddr(String plAddr) {
		this.plAddr = plAddr;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public List<Map<String, String>> getDesc() {
		return desc;
	}
	public void setDesc(List<Map<String, String>> desc) {
		this.desc = desc;
	}
	
	public Command getCmd(){
		Command cmd = new Command();
		String addr = getPlAddr().replaceAll(prefixRegex, "");
		cmd.setBeginAddr(addr);
		CmdType cmdType = cmd.getCmdTypeByAddr();
		cmd.setCmdType(cmdType);
		if(cmdType == CmdType.YX){
			cmd.setReadCount("0008");
		}else{
			cmd.setReadCount("0001");
		}
		String crcStr = Integer.toHexString(ModbusCRC16.crc16_ccitt_modbus(cmd.getCRCByte()));
		cmd.setCrcLowPosition(crcStr.substring(2));
		cmd.setHighPosition(crcStr.substring(0, 2));
		return cmd;
	}
	@Override
	public String toString() {
		return "CommandInfo [sn=" + sn + ", plAddr=" + plAddr + ", sname=" + sname + ", unit=" + unit + ", desc=" + desc
				+ "]";
	}
	
}
