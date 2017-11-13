package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class 编码 {
	public static void main(String[] args) throws Exception{
		test2();
	}
	
	// I/O 涉及的编码示例
	private static void test1() throws Exception{
		String file = "d:/6dev/12.txt"; 
		String charset = "UTF-8"; 
		// 写字符换转成字节流
		FileOutputStream outputStream = new FileOutputStream(file); 
		OutputStreamWriter writer = new OutputStreamWriter( 
		outputStream, charset); 
		try { 
		   writer.write("这是要保存的中文字符"); 
		} finally { 
		   writer.close(); 
		} 
		// 读取字节转换成字符
		FileInputStream inputStream = new FileInputStream(file); 
		InputStreamReader reader = new InputStreamReader( 
		inputStream, charset); 
		StringBuffer buffer = new StringBuffer(); 
		char[] buf = new char[64]; 
		int count = 0; 
		try { 
		   while ((count = reader.read(buf)) != -1) { 
		       buffer.append(buffer, 0, count); 
		   } 
		} finally { 
		   reader.close(); 
		}
	}
	
	//内存中操作中的编码
	private static void test2() throws Exception{
		String s = "这是一段中文字符串"; 
		
		byte[] b1 = s.getBytes("gbk");
		String s1 = new String(b1,"gbk");
		System.out.println("b1-->"+b1);
		System.out.println("s1-->"+s1);
		
		byte[] b2 = s.getBytes("UTF-8"); 
		String s2 = new String(b2,"UTF-8");
		System.out.println("b2-->"+b2);
		System.out.println("s2-->"+s2);
	}
}
