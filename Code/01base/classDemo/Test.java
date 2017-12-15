package classDemo;

public class Test {
	
	public static void main(String[] args) throws Exception {
//		test1();//Java 获取Class对象的三种方法
		test2();//创建Student对象
	}
	
	//Java（反射）获取Class对象的三种方法
	@SuppressWarnings("unused")
	private static void test1() throws Exception{
		//常用第三种
		//1.根据对象的引用.getClass()方法获取
		// 1)需要创建对象，静态块和动态构造块均会执行
		// 2)对象都有了还要反射干什么
		//2.根据类名.class获取
		// 1)不执行静态块和动态构造块
		// 2)需要导入类的包，即：.java文件。依赖太强，不导包就抛编译错误
		//3.根据Class中的静态方法Class.forName(); 
		// 1）执行静态块、不执行动态构造块
		// 2)一个字符串可以传入也可写在配置文件中等多种方法。
		
		//1.根据对象的引用.getClass()方法获取
		//需要创建对象，静态块和动态构造块均会执行
		Student student = new Student();
		Class<? extends Student> clazz1 = student.getClass();
		System.out.println("1----->");
		System.out.println(clazz1.getName());
		System.out.println(clazz1.newInstance());
		System.out.println("");
		
		//2.根据类名.class获取
		//不执行静态块和动态构造块
		Class<? extends Student> clazz2 = Student.class;
		System.out.println("2----->");
		System.out.println(clazz2.getName());
		System.out.println(clazz2.newInstance());
		System.out.println("");
		
		//3.根据Class中的静态方法Class.forName(); 
		//执行静态块、不执行动态构造块
		Class<?> clazz3 = Class.forName("classDemo.Student");
		System.out.println("3----->");
		System.out.println(clazz3.getName());
		System.out.println(clazz3.newInstance());
		System.out.println("");
	}
	
	private static void test2(){
		Student student1 = new Student();
		System.out.println("1");
		Student student2 = new Student();
		System.out.println("2");
	}
	
}
