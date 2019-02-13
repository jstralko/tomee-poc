package com.wk;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class HelloImpl implements Hello {


    @Override
    public String sayHello() {
        return "Hello from Remote EJB";
    }
}
