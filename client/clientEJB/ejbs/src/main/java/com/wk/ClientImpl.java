package com.wk;


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

@Stateless
public class ClientImpl implements Client {

    com.wk.Hello hello;


    @Override
    public String sayHello() {
        return hello.sayHello();
    }

    @PostConstruct
    public void init() {

        System.out.println("Here");

        /*String iiophost = System.getProperty("com.lexi.limsds.iiop.host");
        String iiopport = System.getProperty("com.lexi.limsds.iiop.port");
        String jdni = System.getProperty("com.lexi.limsds.jndiname");
        if (null == iiophost) {
            throw new EJBException("Missing system property com.lexi.limsds.iiop.host!");
        }
        if (null == iiopport) {
            iiopport = "3700";
        }

        try {
            // Set up initial context pointing to LIMS-DS glassfish machine.
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", iiophost);
            props.setProperty("org.omg.CORBA.ORBInitialPort", iiopport);
            InitialContext ic = new InitialContext(props);

            //toMap(ic);

            if (jdni == null) {

                hello = (com.wk.Hello) ic.lookup("com.wk.Hello");
            } else {
                hello = (com.wk.Hello) ic.lookup(jdni);
            }

        } catch (NamingException ex) {
            throw new EJBException(ex);
        }*/


    }
}
