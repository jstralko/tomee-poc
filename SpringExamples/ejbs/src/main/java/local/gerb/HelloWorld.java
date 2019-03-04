package local.gerb;

import javax.ejb.Local;

@Local
public interface HelloWorld {
    public void setName(String name);

	public void printHello();
}