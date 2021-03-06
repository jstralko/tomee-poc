package local.gerb;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

import javax.naming.*;

@Stateless
public class ClientImpl {
    Hello hello;

    public String sayHello() {
        return hello.sayHello();
    }

    @PostConstruct
    public void init() {

        try {
            
            Properties p = new Properties();
            p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
            p.put(Context.PROVIDER_URL, "http://172.17.0.2:8080/tomee/ejb");
            
            InitialContext ic = new InitialContext(p);

            hello = (Hello) ic.lookup("HelloImplRemote");
            String str = hello.sayHello();

            System.err.println("response: " + str);

        } catch (NamingException ex) {
            throw new EJBException(ex);
        }
    }
}
