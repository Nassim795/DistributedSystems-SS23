import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        // args[0]: Hello!
        // args[1]: localhost
        ServerMessage m;

        // 3 methods:  0=AccountingEntries(), 1=getDate(), 2=getName()
        // 0. first method:
        String[] parameters = {"500.0","23.05.2023","Kevins Account"};

        m = transmitMessage(new ClientMessage(0,0, parameters));
        System.out.println("Transaction amount: " + parameters[0]
                + "€, date: " + parameters[1]
                + ", to: " + parameters[2]);
        // 1. second method:
        m = transmitMessage(new ClientMessage(1,0));
        System.out.println("Date : "+m.getReturnValue().toString());

        // 2. third method:
        m = transmitMessage(new ClientMessage(2,0));
        System.out.println("Name : "+m.getReturnValue().toString());
    }

    public static ServerMessage transmitMessage(ClientMessage message) {
        try {

            // System.out.println(" Message: " + args[0]);

            ByteArrayOutputStream byteos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(byteos);
            DatagramSocket aSocket = new DatagramSocket();
            os.writeObject(message);
            os.close();

            // byte[] m = args[0].getBytes();
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 6789;

            DatagramPacket request = new DatagramPacket(byteos.toByteArray(), byteos.toByteArray().length, aHost, serverPort); // m.length = 6
            aSocket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);

            // System.out.println(" Reply: " + new String(reply.getData()));

            ByteArrayInputStream byteis = new ByteArrayInputStream(buffer);
            ObjectInputStream is = new ObjectInputStream(byteis);

            ServerMessage serverMessage = (ServerMessage) is.readObject();
            aSocket.close();

            return serverMessage;
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return null;
    }
}
