package com.wk;

import javax.ejb.Remote;

@Remote
public interface Hello {
    public String sayHello();
}