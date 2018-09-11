package com.tk.bean;

import java.util.List;
import java.util.Map;

/**
 * 命令信息，由次信息可以得到命令{@link Command}
 * @author yang
 *
 */
public class CommandInfo {

	/** **/
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
	
}
