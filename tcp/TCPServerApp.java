import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TCPServerApp {
    public static final int PORT = 8080;
 
    public static void main (String args[]) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            print("Starting sever on: localhost:" + PORT);
            while(true) {            
                Socket newClient = server.accept();
                ObjectInputStream oi = new ObjectInputStream(newClient.getInputStream());
                ObjectOutputStream oo = new ObjectOutputStream(newClient.getOutputStream());
                String messageClient;
                while(true) {
                    messageClient = (String) oi.readObject();
                    print("Received message: " + messageClient);                
                    
                    if (messageClient.equals("exit")) {
                        oo.writeObject(messageClient);
                        break;
                    }

                    oo.writeObject(messageClient.toUpperCase());
                    print("Sended message: " + messageClient.toUpperCase());    
                }                                

                oi.close();
                oo.close();
                newClient.close();                        
            }
        } catch (Exception e) {
            print("Connection error!");
        }        
    }

    public static void print(String msg) {
        System.out.println("TCP SERVER >> " + msg);
    }
}