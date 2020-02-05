package app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] contextPaths = new String[] {"app-context.xml"};
		new ClassPathXmlApplicationContext(contextPaths);
	}

}
