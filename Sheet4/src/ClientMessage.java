import java.io.Serializable;

public class ClientMessage implements Serializable {
    private int method; //3 methods
    private int account;
    String[] parameters; //for the constructor AccountingEntries()

    public ClientMessage(int method, int account, String[] parameters) {
        this.method = method;
        this.account = account;
        this.parameters = parameters;
    } // for method 0

    public ClientMessage(int method, int account) {
        this.method = method;
        this.account = account;
    } // for method 1 and 2

    public int getMethod() {
        return method;
    }

    public int getAccount() {
        return account;
    }

    public String[] getParameters() {
        return parameters;
    }
}

