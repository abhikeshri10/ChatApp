import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Send implements Runnable {
    private Socket socket;
    public BufferedReader bufferedReader;
    ObjectOutputStream objectOutputStream;
    Send(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
        
    }

    public void run() {
        
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e1) {
            //TODO Auto-generated catch block
            e1.printStackTrace();
        }
        while (true) {
            
            try {
            
            System.out.println("Enter the message::");
            String text = bufferedReader.readLine();
            String from = "Server";
            Message message = new Message(text ,from,"You");
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
            } 
            catch (IOException e){
                
                e.printStackTrace();
                
            }
            
        }
    }
}