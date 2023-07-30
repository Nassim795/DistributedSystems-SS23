import java.io.Serializable;

public class AccountingEntries implements Serializable {
    private double amount;
    private String date;
    private String otherAccount;

    public AccountingEntries(double amount, String date, String otherAccount) {
        this.amount = amount;
        this.date = date;
        this.otherAccount = otherAccount;
    }   // this must be used

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getOtherAccount() {
        return otherAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
