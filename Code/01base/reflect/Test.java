package reflect;

import java.lang.reflect.Method;

/**
 * 反射
 * 1,反编译：.class-->.java
 * 2,通过反射机制访问java对象的属性，方法，构造方法等；
            这样好像更容易理解一些，下边我们具体看怎么实现这些功能。
 */
public class Test {
    public static void main(String[] args){
    	try {  
            Class<?> clazz = Class.forName("java.util.HashSet");             
            Object hashSet = clazz.newInstance();  
            Method[] methods = clazz.getDeclaredMethods();  
            for(Method method : methods){  
                System.out.println(method);  
            }  
            Method m1 = clazz.getMethod("add", Object.class);  
            m1.invoke(hashSet, "cyq");  
            m1.invoke(hashSet, "hello");  
            m1.invoke(hashSet, "java");
            System.out.println(hashSet);  
        } catch (Exception e) {           
            e.printStackTrace();  
        }
    }
}
