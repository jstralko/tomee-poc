package local.gerb;

import javax.ejb.Stateless;

/**
 * Spring bean
 * 
 */
@Stateless
public class HelloWorldImpl implements HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello ! " + name);
	}
}
