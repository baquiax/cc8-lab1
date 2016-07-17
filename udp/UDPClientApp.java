import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientApp {
    private static final String IP = "localhost";
    private static final int PORT = 8080;
    
    public static void main(String args[]) {
        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName(IP);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            print("Connection stablished to:" + IP + ":" + PORT);
            print("--- Write 'exit' to quit.");            
            Scanner keyboard = new Scanner(System.in);
            
            while(true) {
                System.out.print("> ");
                sendData = keyboard.nextLine().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, PORT);
                s.send(sendPacket);                
                print("Sended: " + new String(sendData));

                DatagramPacket receivedPacket = new DatagramPacket(receiveData, receiveData.length);
                s.receive(receivedPacket);
                String responseObject = new String(receivedPacket.getData());
                responseObject = responseObject.trim();
                if (responseObject.equals("exit")) {
                    break;
                }
                print("Received: " + responseObject);                
            }                        
            s.close(); 
        } catch(Exception e) {
            print("Connection error!");            
        }
    }

    public static void print(String msg) {
        System.out.println("UDP CLIENT >> " + msg.trim());
    }
}