import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//sever to client client to server

public class Client {

    public static void main(String args[]) {

        try {
            Socket socket = new Socket("localhost", 5436);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client created.");
            System.out.println("Enter name of client.");
            String name = bufferedReader.readLine();
            // Thread t = new Thread(new HandleClient(socket));
            // t.start();
            
                try {
                    Thread t2 = new Thread(new Send(socket, bufferedReader));
                    t2.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("Server Connected");
                    Thread t = new Thread(new HandleClient(socket));
                    t.start();
                } catch (Exception e) {
                    e.printStackTrace();

          
                // new Client().sendMessage(socket, bufferedReader, name);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // public void sendMessage
    // (Socket socket, BufferedReader bufferedReader, String name)
    // throws IOException {
    // ObjectOutputStream objectOutputStream =
    // new ObjectOutputStream(socket.getOutputStream());

    // while (true) {

    // System.out.println("Press 1 to quit");
    // int ch = Integer.parseInt(bufferedReader.readLine());
    // if (ch == 1) {
    // break;
    // }

    // System.out.println("Enter message");
    // String text = bufferedReader.readLine();
    // String from = "Client - " + name;
    // Message message = new Message(text, from, "Server");
    // objectOutputStream.writeObject(message);
    // objectOutputStream.flush();

    // }
    // }
}