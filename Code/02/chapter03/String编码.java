package chapter03;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class String编码 {
	public static void main(String[] args){
		encode();
	}
	
	public static void encode(){
//		String name = "I am 寳山";
		String name = "I am 君山";
		byte[] defaultByte = name.getBytes();
		try{
			byte[] iso8859 = name.getBytes("ISO-8859-1");
			toHex(iso8859);
			byte[] gb2312 = name.getBytes("GB2312");
			toHex(gb2312);
			byte[] gbk = name.getBytes("GBK");
			toHex(gbk);
			byte[] utf16 = name.getBytes("UTF-16");
			toHex(utf16);
			byte[] utf8 = name.getBytes("UTF-8");
			toHex(utf8);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}

	private static String toHex(byte[] byteArr){
		String returnStr = DatatypeConverter.printHexBinary(byteArr);
		System.out.println(returnStr);
        return returnStr;  
	}
}
