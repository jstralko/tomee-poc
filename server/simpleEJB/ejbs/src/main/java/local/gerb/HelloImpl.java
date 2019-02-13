package local.gerb;

import javax.ejb.Stateless;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HelloImpl implements Hello {

    @Resource(name="MyJmsConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="MyQueue")
    private Queue myQueue;

    @Resource(name="MyTopic")
    private Topic myTopic;

    @PersistenceContext(unitName="datasource-unit")
    private EntityManager entityManager;

    @Override
    public void storeValue() {
        entityManager.persist(new Foo("FooBar!"));
    }

    @Override
    public String sayHello() {
        return "Hello from Remote EJB";
    }

    @Override
    public void sendMessageToTopic(String text) throws JMSException {

        Connection connection = null;
        Session session = null;
  
        try {
            connection = connectionFactory.createConnection();
            //Connection is get from ConnectionFactory instance and it is started.
            connection.start(); 
  
            //Creates a session to created connection.
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
  
            //Creates a MessageProducer from Session to the Queue.
            MessageProducer producer = session.createProducer(myTopic);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); 
  
            TextMessage message = session.createTextMessage(text);
  
            //Tells the producer to send the message
            producer.send(message); 
        }
        finally {
            if (session != null) session.close(); 
            if (connection != null) connection.close();
        }
    }

    @Override
    public String sendJMS(String text) throws JMSException {

        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            //Connection is get from ConnectionFactory instance and it is started.
            connection.start(); 

            //Creates a session to created connection.
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 

            //Creates a MessageProducer from Session to the Queue.
            MessageProducer producer = session.createProducer(myQueue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); 

            TextMessage message = session.createTextMessage(text);

            //Tells the producer to send the message
            producer.send(message); 
        }
        finally {
            if (session != null) session.close(); 
            if (connection != null) connection.close();
        }

        return "here";
    }
}
