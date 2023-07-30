import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("Nassims Account");
        account.addEntry(500,"01.05.2022","Kevins Account");
        account.addEntry(-20,"04.05.2022","Bobs Account");
        account.addEntry(-20,"04.05.2022","Bobs Account");
        account.addEntry(-100.50,"01.05.2022","Lisas Account");

        Set<AccountingEntries> entries = account.getEntries();
        double total=0;
        for (AccountingEntries entry:entries
             ) {
            total += entry.getAmount();
            System.out.println("Entry : ("+entry.getAmount()+") Date : ("+entry.getDate()+") To : "+entry.getOtherAccount());
        }
        System.out.println("Total Amount : "+total);

        AccountingEntries entry1 = account.searchEntry(500);
        if (entry1 != null) System.out.println("Found : "+entry1.getAmount());
        else System.out.println("Error Not Found");

        AccountingEntries entry2 = account.searchEntry(10);
        if (entry2 != null) System.out.println("Found : "+entry2.getAmount());
        else System.out.println("Error Not Found");
    }
}
