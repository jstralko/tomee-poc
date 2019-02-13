package local.gerb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue="MyTopic")
    }
)
public class Listener2 implements MessageListener {

    public void onMessage(Message message) {
        try {

            final TextMessage textMessage = (TextMessage) message;
            final String text = textMessage.getText();
            System.out.println("Consumed message: " + text);
        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }
}