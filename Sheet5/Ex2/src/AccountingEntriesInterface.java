import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountingEntriesInterface extends Remote {
    public double getAmount() throws RemoteException;
    public String getDate() throws RemoteException;
    public String getOtherAccount() throws RemoteException;
    public void setAmount(double amount) throws RemoteException;
}
