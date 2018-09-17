package com.tk.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tk.bean.Command;
import com.tk.bean.CommandInfo;
import com.tk.util.CmdUtil;
import com.tk.util.Crc32;
import com.tk.util.ModbusCRC16;
import com.tk.util.StringUtil;

public class Test {

	public static void main(String[] args) {
				
		// send data by socket
		String serverName = null;
		Integer port = null;
		String[] cmdIds = {"2MainRun","2"};
		CommandInfo cmdInfo = CmdUtil.getCmdInfoBy(cmdIds);
		System.out.println("cmdInfo: " + cmdInfo.toString());
		Command cmd = cmdInfo.getCmd();
		System.out.println("beginAddr--->" + cmd.getBeginAddr());
		System.out.println("cmd--->" + StringUtil.bin2HexStr(cmd.getCmdBytes()));
		 try {
			Socket client = new Socket(serverName, port);
//			OutputStream out = client.getOutputStream();
			DataOutputStream out =  new DataOutputStream(client.getOutputStream());
			//TODO send byte data
			out.write(cmd.getCmdBytes());
			DataInputStream in = new DataInputStream(client.getInputStream());
			String res = in.readUTF();
			System.out.println("server response:" + res);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static <E> List<E> helper(List<E> list){
		List<E> l = new ArrayList<E>();
		l.addAll(list);
		return l;
	}
	
	/*
	 * p100
	 */
	private static void unsafeAdd(List list, Object o){
		list.add(o);
	}

	private static void unsafeAdd2(List<Object> list, Object o){
		list.add(o);
	}
	
	private static void unsafeAdd3(List<?> list, Object o){
		list = helper(list);
//		list.add(o);
	}
	
	@org.junit.Test
	public void taaa(){
//		Object[] objs = new Long[1];
//		objs[0] = "hi";
//		List<String[]> a;
//		List<String>[] b;
//		a = new ArrayList<String[]>();
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		Object[] objs = nums.toArray();
		Object[] a = {1,2,3};
		Integer[] b = (Integer[]) a;
		System.out.println("b: " + b);
		System.out.println();
		Integer[] is = (Integer[]) nums.toArray();
		System.out.println(is);
	}
	
	@org.junit.Test
	public void prefixRegex(){
		String prefixRegex = "4WUB|4WB";
		String test1 = "4WUB8088";
		String test2 = "4WB9000";
		System.out.println("test1--->" + test1.replaceAll(prefixRegex, ""));
		System.out.println("test2--->" + test2.replaceAll(prefixRegex, ""));
	}
	
	@org.junit.Test
    public void testa(){
    	//3D FF
    	String s = "020100000008";
    	
    	int i = ModbusCRC16.crc16_ccitt_modbus(StringUtil.hexStr2BinArr(s));
    	System.out.println(Integer.toHexString(i));
		String[] crcStrs =  Crc32.splitCrc(StringUtil.hexStr2BinArr(s));
		System.err.println(crcStrs[0] + "--" + crcStrs[1]);
    }
}
