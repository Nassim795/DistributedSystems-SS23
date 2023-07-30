import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;
import java.util.Set;

public class Receiver {
    public static Account account1 = new Account("Nassim Laaraj");
    public static Account account2 = new Account("Andrew Tate");

    public static void main(String[] argv) throws Exception {

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

        while (true){
            TextMessage query = (TextMessage) receiver.receive();
            TextMessage answer = session.createTextMessage();

            String[] querySplit = query.getText().split("/");

            Account account = null;
            if (querySplit[0].equals("0")){
                account = account1;
            } else if (querySplit[0].equals("1")) {
                account = account2;

            } else
                answer.setText("Account doesn't exist");

            if (querySplit[1].equals("0")){ //The first method:
                double amount = Double.parseDouble(querySplit[2]);
                account.addEntry(amount, querySplit[3], querySplit[4]);
                answer.setText("Entry added with the amount "+amount);

            } else if (querySplit[1].equals("1")) { //The second method:
                Set<AccountingEntries> entries = account.getEntries();
                int total = 0;
                for (AccountingEntries ae : entries) {
                    total++;
                }
                answer.setText("Total entries : "+total);

            } else if (querySplit[1].equals("2")) { //The third method:
                double amount = Double.parseDouble(querySplit[2]);
                AccountingEntries entry = account.searchEntry(amount);
                if (entry != null) {
                    answer.setText("Entry with the amount: " + entry.getAmount()+ " found.");
                } else {
                    answer.setText(entry+"Entry not found!");
                }
            } else
                answer.setText("method not found");
            System.out.println("Message Received: "+query.getText());
            System.out.println("Message Sent: "+answer.getText());
            sender.send(answer);
        }
    }
}