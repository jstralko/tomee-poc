package local.gerb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(
    mappedName = "MyQueue",
    activationConfig = { 
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") 
    }
)
public class SimpleMDB implements MessageListener {

    public void onMessage(Message message) {
        try {

            final TextMessage textMessage = (TextMessage) message;
            final String question = textMessage.getText();
        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }
}