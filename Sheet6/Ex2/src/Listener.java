import javax.jms.*;
import java.util.Set;

public class Listener implements MessageListener {
    QueueSender sender;
    QueueSession session;

    public Listener(QueueSender sender, QueueSession session){
        this.sender = sender;
        this.session = session;
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage query = (TextMessage)message;
            TextMessage answer = session.createTextMessage();

            String[] querySplit = query.getText().split("/");

            Account account = null;
            if (querySplit[0].equals("0")){
                account = ReceiverForListener.account1;
            } else if (querySplit[0].equals("1")) {
                account = ReceiverForListener.account2;

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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
