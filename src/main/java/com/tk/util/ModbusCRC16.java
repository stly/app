package com.tk.util;

public class ModbusCRC16 {

	   /**
     * crc16_ccitt_modbus算法（四字节）友情提示：做好自己！--eguid博客地址：http://blog.csdn.net/eguid_1
     * @param buf
     * @param offset
     * @param length
     * @return
     */
    public static int crc16_ccitt_modbus(byte[] buf,int offset, int length) {
		int i, j;
		int c, crc = 0xFFFF;
		for (i = offset; i < length; i++) {
			c = buf[i] & 0x00FF;
			crc ^= c;
			for (j = 0; j < 8; j++) {
				if ((crc & 0x0001) != 0) {
					crc >>= 1;
					crc ^= 0xA001;
				} else
					crc >>= 1;
			}
		}
		return crc;
	}
    
    /**
     * crc16_ccitt_modbus算法（四字节）
     * @param buf
     * @return
     */
    public static int crc16_ccitt_modbus(byte[] buf) {
  		return crc16_ccitt_modbus(buf,0,buf.length);
  	}
    
    
    /**
     * crc16_ccitt_modbus算法（两字节）
     * @param buf
     * @param offset
     * @param length
     * @return
     */
    public static int crc16_ccitt_modbus_short(byte[] buf,int offset, int length) {
    	return (short)crc16_ccitt_modbus(buf,offset,length);
    }
    
    /**
     * crc16_ccitt_modbus算法（两字节）
     * @param buf
     * @return
     */
    public static int crc16_ccitt_modbus_short(byte[] buf) {
    	return (short)crc16_ccitt_modbus(buf,0,buf.length);
    }
}
