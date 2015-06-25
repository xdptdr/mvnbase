package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.xdptdr.MyBean;

public class Main {
	public static void main(String[] args) {
		String loc = "classpath:/appcontext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(loc);
		MyBean foobar = ac.getBean("foobar",MyBean.class);
		System.out.println(foobar.getCount());
		System.out.println(foobar.getCount());
		System.out.println(foobar.getCount());
		ac.close();	
	}
}
