import java.rmi.Naming;
import java.util.List;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        try {                                                       // Client loop up the obj.
            AccountInterface accountOne = (AccountInterface) Naming.lookup("rmi://localhost/accountOne");
            AccountInterface accountTwo = (AccountInterface) Naming.lookup("rmi://localhost/accountTwo");
                                //Client invokes method
            //getName()
            System.out.println("1.Account's Name : "+accountOne.getName());
            System.out.println("2.Account's Name : "+accountTwo.getName());

            //addEntry()
            accountOne.addEntry(500.0,"04.06.2023","Kevin's Account");
            accountOne.addEntry(12.50,"05.05.2023","Ali's Account");
            accountOne.addEntry(-50.99,"11.05.2023","Lisa's Account");

            //getDates()
            List<String> dates = accountOne.getDates();
            System.out.println("Dates: " + dates);

            //searchEntry()
            AccountingEntriesInterface entry = accountOne.searchEntry(12.50);

            if (entry != null) {
                System.out.println("Entry with the amount: " + entry.getAmount()+" found.");
                System.out.println("Entry's Date: " + entry.getDate());
                System.out.println("Entry's Other Account: " + entry.getOtherAccount());

                System.out.print("The Entry changed from "+entry.getAmount());

                //setAmount(double amount)
                entry.setAmount(13);
                System.out.println(", to "+entry.getAmount());
            } else {
                System.out.println("Not found!");
            }

            // getEntries()
            Set<AccountingEntriesInterface> entries = accountOne.getEntries();
            System.out.println("---------- All Entries : ----------");

            double total = 0;
            for (AccountingEntriesInterface e : entries) {
                System.out.println("Amount: " + e.getAmount());
                System.out.println("Date: " + e.getDate());
                System.out.println("Other Account: " + e.getOtherAccount());
                System.out.println("**************");
                total += e.getAmount();
            }
            System.out.println();
            System.out.println("Total Credit : " + total);

        } catch (Exception e) {
            System.out.println("Client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
