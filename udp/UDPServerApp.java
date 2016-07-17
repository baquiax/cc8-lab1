import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDPServerApp {
    public static final int PORT = 8080;
 
    public static void main (String args[]) {
        try {
            DatagramSocket server = new DatagramSocket(PORT);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            print("Starting sever on: localhost:" + PORT);
            
            while(true) {            
                DatagramPacket client = new DatagramPacket(receiveData, receiveData.length);
                server.receive(client);
                InetAddress IPAddress = client.getAddress();
                int port = client.getPort();

                String messageClient = new String(client.getData());  
                messageClient = messageClient.trim();
                print("Received message: " + messageClient);                
                    
                if (messageClient.equals("exit")) {
                    sendData = messageClient.getBytes();
                    server.send(new DatagramPacket(sendData, sendData.length, IPAddress, port));
                    break;
                }
                  
                sendData = messageClient.toUpperCase().getBytes();
                server.send(new DatagramPacket(sendData, sendData.length, IPAddress, port));
                print("Sended message: " + messageClient.toUpperCase());                                                                        
            }
        } catch (Exception e) {
            print("Connection error!");
        }        
    }

    public static void print(String msg) {
        System.out.println("UDP SERVER >> " + msg.trim());
    }
}