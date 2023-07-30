import java.util.HashSet;

public class Account {
    private String name;
    private HashSet<AccountingEntries> entries;

    public Account(String name) {
        this.name = name;
        this.entries = new HashSet<>();
    }

    public AccountingEntries searchEntry (double amount){
        for (AccountingEntries entry:entries) {
            if (entry.getAmount()==amount){
                return entry;
            }
        }
        return null;
    }

    public void addEntry(double amount, String date, String otherAccount) {
        AccountingEntries entry = new AccountingEntries(amount,date,otherAccount);
        entries.add(entry);
    }

    public String getName() {
        return name;
    }

    public HashSet<AccountingEntries> getEntries() {
        return entries;
    }
}
