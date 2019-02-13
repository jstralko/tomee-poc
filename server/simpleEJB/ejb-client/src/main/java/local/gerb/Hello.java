package local.gerb;

import javax.ejb.Remote;
import javax.jms.JMSException;

@Remote
public interface Hello {
    public String sayHello();

    public String sendJMS(String text) throws JMSException;

    public void sendMessageToTopic(String text) throws JMSException;

    public void storeValue();
}