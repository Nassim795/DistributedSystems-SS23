import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface AccountInterface extends Remote {
    public AccountingEntriesInterface searchEntry (double amount) throws RemoteException;
    public void addEntry(double amount, String date, String otherAccount) throws RemoteException;
    public String getName() throws RemoteException;
    public Set<AccountingEntriesInterface> getEntries() throws RemoteException;
    public List<String> getDates() throws RemoteException;
}
