import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TCPClientApp {
    private static final String IP = "localhost";
    private static final int PORT = 8080;
    
    public static void main(String args[]) {
        try {
            Socket s = new Socket(IP, PORT);
            print("Connection stablished to:" + IP + ":" + PORT);
            print("--- Write 'exit' to quit.");
            ObjectOutputStream oo = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
            Scanner keyboard = new Scanner(System.in);
            String sendObject, responseObject;

            while(true) {
                System.out.print("> ");
                sendObject = keyboard.nextLine();
                oo.writeObject(sendObject);
                print("Sended: " + sendObject);            
                responseObject = (String) oi.readObject();
                if (responseObject.equals("exit")) {
                    break;
                }
                print("Received: " + responseObject);                
            }
            
            oo.close();
            oi.close();
            s.close(); 
        } catch(Exception e) {
            print("Connection error!");            
        }
    }

    public static void print(String msg) {
        System.out.println("TCP CLIENT >> " + msg);
    }
}