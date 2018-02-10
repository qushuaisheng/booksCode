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
		toHex(defaultByte);
		
		try{
			byte[] iso8859 = name.getBytes("ISO-8859-1");
			toHex(iso8859);
			//49 20  61 6D 20  3F 3F
			//I  空格  a  m  空格   ?  ?
			//因为在ISO-8859-1中不支持中文，所以为?
			
			byte[] gb2312 = name.getBytes("GB2312");
			toHex(gb2312);
			//49 20  61 6D  20  BEFD C9BD
			//I  空格  a   m  空格   君        山
			
			byte[] gbk = name.getBytes("GBK");
			toHex(gbk);
			//49 20  61 6D  20  BEFD C9BD
			//I  空格  a   m  空格   君        山
			
			byte[] utf16 = name.getBytes("UTF-16");
			toHex(utf16);
			//0049 0020 0061 006D 0020 541B 5C71
			//I    空格     a    m    空格    君        山
			
			byte[] utf8 = name.getBytes("UTF-8");
			toHex(utf8);
			//49 20  61 6D 20  E5909B E5B1B1
			//I  空格  a  m  空格   君            山
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
