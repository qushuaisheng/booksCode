package classDemo;

public class Student {
	private String name;
	private String age;
	
	static{
		System.out.println("1234");
	}
	
	public Student(){
		this.name = "李白";
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age;
	}
	
	public String toString(){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(getClass().getName()).append("@").
			append(hashCode()).append("{").append(SystemUtils.LINE_SEPARATOR);
		strBuf.append("	name=").append(getName()).append(SystemUtils.LINE_SEPARATOR);
		strBuf.append("	age=").append(getAge()).append(SystemUtils.LINE_SEPARATOR);
		strBuf.append("}");
		
		return strBuf.toString();
	}
	
}
