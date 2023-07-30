import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountImpl extends UnicastRemoteObject implements AccountInterface {
    private String name;
    private HashSet<AccountingEntriesInterface> entries;

    public AccountImpl(String name) throws RemoteException {
        this.name = name;
        this.entries = new HashSet<>();
    }


    public AccountingEntriesInterface searchEntry (double amount) throws RemoteException{
        for (AccountingEntriesInterface entry:entries) {
            if (entry.getAmount()==amount){
                return entry;
            }
        }
        return null;
    }

    public void addEntry(double amount, String date, String otherAccount) throws RemoteException{
        AccountingEntriesImpl entry = new AccountingEntriesImpl(amount,date,otherAccount);
        entries.add(entry);
    }

    public String getName() throws RemoteException{
        return name;
    }
    //From HashSet to Set
    public Set<AccountingEntriesInterface> getEntries() throws RemoteException{
        return entries;
    }

    public List<String> getDates() throws RemoteException{
        ArrayList<String> dates = new ArrayList<>();
        for (AccountingEntriesInterface ae: entries) {
            String date = ae.getDate();
            dates.add(date);
        }
        return dates;
    }
}
