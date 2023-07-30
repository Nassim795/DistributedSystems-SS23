import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class ReceiverForListener{
    public static Account account1 = new Account("Nassim Laaraj");
    public static Account account2 = new Account("Andrew Tate");

    public static void main(String argv[]) throws Exception {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);

        QueueConnectionFactory connFactory = (QueueConnectionFactory)context.lookup("ConnectionFactory");

        QueueConnection conn = connFactory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue receiveQueue = (Queue) context.lookup("dynamicQueues/queue1");
        Queue sendQueue = (Queue) context.lookup("dynamicQueues/queue2");

        QueueReceiver receiver = session.createReceiver(receiveQueue);
        QueueSender sender = session.createSender(sendQueue);

        conn.start();
        System.out.println("Server running..");
        receiver.setMessageListener(new Listener(sender,session));
        }
    }