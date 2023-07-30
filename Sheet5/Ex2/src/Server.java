import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {

            AccountImpl[] account = new AccountImpl[2];

            account[0] = new AccountImpl("Nassim Laaraj");
            account[1] = new AccountImpl("Andrew Tate");
            // Server rebinds Obj. to nameserver
            Naming.rebind("accountOne",account[0]);
            Naming.rebind("accountTwo",account[1]);

            System.out.println("The server is up");

        } catch (Exception e) {
            System.out.println("Server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
