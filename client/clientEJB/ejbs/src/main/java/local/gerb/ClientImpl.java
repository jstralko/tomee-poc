package local.gerb;


import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;


import javax.naming.*;

@Stateless
public class ClientImpl implements Client {
    local.gerb.Hello hello;

    @Override
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

            hello = (local.gerb.Hello) ic.lookup("HelloImplRemote");
            String str = hello.sayHello();

            System.err.println("response: " + str);

        } catch (NamingException ex) {
            throw new EJBException(ex);
        }


    }
}
