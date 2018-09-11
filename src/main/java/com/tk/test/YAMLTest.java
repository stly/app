package com.tk.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import com.tk.bean.AppInfo;
import com.tk.bean.CommandInfo;
import com.tk.bean.PageCmdInfo;
import com.tk.util.StringUtil;

public class YAMLTest {
	
	@Test
	public void testCmd2Byte(){
		String hex = "006C";
//		hex = "6C";
		String s = StringUtil.hexStr2BinStr(hex);
		System.err.println(s);
		System.err.println(Integer.valueOf(s, 2));
	}

	@Test
	public void testLoad() {
		String yamlStr = "key: hello yaml";
		Yaml yaml = new Yaml();
		Object ret = yaml.load(yamlStr);
		System.out.println(ret);
	}
	
	@Test
	public void testType() throws Exception {
		Yaml yaml = new Yaml();
		List<String> ret = (List<String>) yaml.load(this.getClass().getClassLoader().getResourceAsStream("test.yaml"));
		System.out.println(ret);
	}
	
	@Test
	public void test2() throws Exception {
		Yaml yaml = new Yaml();
		Map<String, Object> ret = (Map<String, Object>) yaml
				.load(this.getClass().getClassLoader().getResourceAsStream("cmd.yaml"));
		System.out.println(ret);
		AppInfo app = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("cmd.yaml"), AppInfo.class);
		System.err.println(app.getPage().get(0).getCmds().get(0).getPlAddr());
	}
	
	/**
	 * 
	 * @param id: [page, sn]
	 * @return
	 */
	public CommandInfo getCmdInfoBy(String[] id){
		Yaml yaml = new Yaml();
		AppInfo app = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("cmd.yaml"), AppInfo.class);
		String page = id[0], sn = id[1];
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
	
	@Test
	public void testGetCmdInfo(){
		String[] id = {"2MainRun","2"};
		CommandInfo cmdInfo = getCmdInfoBy(id);
		System.err.println(cmdInfo.getPlAddr());
	}

}
