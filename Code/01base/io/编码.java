package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
//java web 第三章
public class 编码 {
	public static void main(String[] args) throws Exception{
//		test21();
//		test22();
		test3();
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
	
	//内存中操作中的编码：方式一
	private static void test21() throws Exception{
		String s = "这是一段中文字符串"; 
		
		//String 类就提供转换到字节的方法
		byte[] b1 = s.getBytes("gbk");
		//也支持将字节转换为字符串的构造函数
		String s1 = new String(b1,"gbk");
		System.out.println("b1-->"+b1);
		System.out.println("s1-->"+s1);
		
		byte[] b2 = s.getBytes("UTF-8"); 
		String s2 = new String(b2,"UTF-8");
		System.out.println("b2-->"+b2);
		System.out.println("s2-->"+s2);
	}
	
	//内存中操作中的编码：方式二
	//编码与解码都在一个类中完成，通过 forName 
	//设置编解码字符集，这样更容易统一编码格式。
	private static void test22(){
		Charset charset = Charset.forName("UTF-8"); 
		ByteBuffer byteBuffer = charset.encode("abc");
		System.out.println(byteBuffer);
		
		CharBuffer charBuffer = charset.decode(byteBuffer);
		System.out.println(charBuffer);
	}
	
	//Java 中还有一个 ByteBuffer 类，它提供一种 char 和 byte 之间的软转换，
	//它们之间转换不需要编码与解码，只是把一个 16bit 的 char 格式，拆分成为 2 个 8bit 的 byte 表示，它们的实际值并没有被修改，仅仅是数据的类型做了转换。如下代码所以：
	private static void test3(){
		ByteBuffer heapByteBuffer = ByteBuffer.allocate(1024);
		System.out.println(heapByteBuffer);
		ByteBuffer byteBuffer = heapByteBuffer.putChar('c');
		System.out.println(byteBuffer);
	}
}
