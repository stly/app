package com.tk.bean;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.yaml.snakeyaml.Yaml;

import com.tk.util.StringUtil;

public class CmdManager {

	static ServerInfo server;
	static{
		Yaml yaml = new Yaml();
		server = yaml.loadAs(CmdManager.class.getClassLoader().getResourceAsStream("server.yaml"), ServerInfo.class);
	}
	private CmdManager(){
	}
	
	static CmdManager cm = new CmdManager();
	
	public static CmdManager getCmdManager(){
		return cm;
	}
	
	/**
	 * 发送指令
	 * @param cmd
	 * @return
	 * @throws Exception
	 */
	public String sendCmd(Command cmd) throws Exception{
		@SuppressWarnings("resource")
		Socket client = new Socket(server.getHost(), server.getPort());
		System.out.println("RemoteSocketAddress--->" + client.getRemoteSocketAddress());

		DataOutputStream out =  new DataOutputStream(client.getOutputStream());
		out.write(StringUtil.hexStr2BinArr(cmd.cmd()));;
		DataInputStream in = new DataInputStream(client.getInputStream());
		byte[] buf = new byte[in.available()];
		System.out.println("buf--->" + StringUtil.bin2HexStr(buf));
		String res = StringUtil.bin2HexStr(buf);
		cmd.setByteData(res);
		return res;
	}
}
