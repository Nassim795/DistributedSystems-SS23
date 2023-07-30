import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServer {
    public static void main(String[] args){
        // Two accounts :
        Account[] account = new Account[2];
        account[0] = new Account("Nassim Laaraj");
        account[1] = new Account("Andrew Tate");

        System.out.println("The Server is running..");
        try{
            DatagramSocket aSocket = new DatagramSocket (6789);
            byte[] buffer = new byte[1000];

            while(true){
                DatagramPacket request = new DatagramPacket (buffer, buffer.length);
                aSocket.receive (request);
                // Request received ab hier
                // Deserialize the request
                ByteArrayInputStream byteis = new ByteArrayInputStream(buffer);
                ObjectInputStream is = new ObjectInputStream(byteis);

                ClientMessage message = (ClientMessage)is.readObject();
                ServerMessage response = null;

                int a = message.getAccount(); // account[0] or account[1]
                int method = message.getMethod(); // 0=AccountingEntries(), 1=getDate(), 2=getName()
                System.out.println("method : "+method);

                if (method==0) {// methods
                    String[] parameters = message.getParameters();
                    double amount = Double.parseDouble(parameters[0]);
                    account[a].addEntry(amount, parameters[1], parameters[2]);
                    response = new ServerMessage(true);
                } else if (method==1) {
                    response = new ServerMessage(account[a].getDates());
                } else if (method==2) {
                    response = new ServerMessage(account[a].getName());
                }

                //System.out.println(" Request: " + new String(request.getData(), 0, request.getLength()));

                //Serialize the return value
                ByteArrayOutputStream byteos = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(byteos);
                os.writeObject(response);
                os.close();

                DatagramPacket reply = new DatagramPacket (byteos.toByteArray(),
                        byteos.toByteArray().length, request.getAddress(), request.getPort());
                aSocket.send (reply);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}