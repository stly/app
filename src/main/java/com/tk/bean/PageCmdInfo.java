package com.tk.bean;

import java.util.List;

public class PageCmdInfo {

	private String name;
	private List<CommandInfo> cmds;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CommandInfo> getCmds() {
		return cmds;
	}
	public void setCmds(List<CommandInfo> cmds) {
		this.cmds = cmds;
	}
}
