package com.tk.util;

import org.yaml.snakeyaml.Yaml;

import com.tk.bean.AppInfo;
import com.tk.bean.Command;
import com.tk.bean.CommandInfo;
import com.tk.bean.PageCmdInfo;

public class CmdUtil {

	/**
	 * 
	 * @desc   获取命令的标识，一个命令有页码和命令编号唯一确定		
	 * @param cmdIds  ex: String[] id = {"2MainRun","2"};
	 *
	 */
	public static CommandInfo getCmdInfoBy(String[] cmdIds){
		Yaml yaml = new Yaml();
		AppInfo app = yaml.loadAs(CmdUtil.class.getClassLoader().getResourceAsStream("cmd.yaml"), AppInfo.class);
		String page = cmdIds[0], sn = cmdIds[1];
		if(app != null && app.getPage().size() > 0){
			for (PageCmdInfo pageCmdInfo : app.getPage()) {
				if(pageCmdInfo.getName().equals(page)){
					for (CommandInfo cmdInfo : pageCmdInfo.getCmds()) {
						if(cmdInfo.getSn().equals(sn)){
							return cmdInfo;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @desc   获取cmd
	 * @param cmdInfo
	 * @return
	 * @email  gnayi@qq.com
	 *
	 */
	public static Command getCmd(CommandInfo cmdInfo){
		if(cmdInfo == null)
			return null;
		return null;
	}
}
