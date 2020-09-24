import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;

public class Server {

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket;
        Socket socket;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(5436);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Client Connected");
                Thread t = new Thread(new HandleClient(socket));//listen message from client
                t.start();
                Thread t2 = new Thread(new Send(socket, bufferedReader));//send message from server
                t2.start();
            } 
            catch (IOException e) {
                e.printStackTrace();
                
            }
            // System.out.println("To send message Enter 2");
            // int a = Integer.parseInt(bufferedReader.readLine());
            // if(a==2){
           
        
        }
    }

}