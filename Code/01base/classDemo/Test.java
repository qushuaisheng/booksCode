package classDemo;

public class Test {
	
	public static void main(String[] args) throws Exception {
//		test1();//Java 获取Class对象的三种方法
		test2();//创建Student对象
	}
	
	//Java 获取Class对象的三种方法
	@SuppressWarnings("unused")
	private static void test1() throws Exception{
		//1.根据对象的引用.getClass()方法获取
		Student student = new Student();
		Class<? extends Student> clazz1 = student.getClass();
		System.out.println("1----->");
		System.out.println(clazz1.getName());
		System.out.println(clazz1.newInstance());
		System.out.println("");
		
		//2.根据类名.class获取
		Class<? extends Student> clazz2 = Student.class;
		System.out.println("2----->");
		System.out.println(clazz2.getName());
		System.out.println(clazz2.newInstance());
		System.out.println("");
		
		//3.根据Class中的静态方法Class.forName(); 
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
