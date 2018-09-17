package com.tk.bean;

public enum CmdType {
	YX(1),YC(2);
	
	private Integer type;
	private CmdType(Integer type){
		this.type = type;
	}
}
