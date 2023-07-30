import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountingEntriesImpl extends UnicastRemoteObject implements AccountingEntriesInterface {
    private double amount;
    private String date;
    private String otherAccount;

    public AccountingEntriesImpl(double amount, String date, String otherAccount) throws RemoteException {
        //super();
        this.amount = amount;
        this.date = date;
        this.otherAccount = otherAccount;
    }

    public double getAmount() throws RemoteException {
        return amount;
    }

    public String getDate() throws RemoteException {
        return date;
    }

    public String getOtherAccount() throws RemoteException {
        return otherAccount;
    }

    public void setAmount(double amount) throws RemoteException {
        this.amount = amount;
    }
}
