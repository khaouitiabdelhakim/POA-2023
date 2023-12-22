package exo2question2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HandleClient implements Runnable{
    Socket client;

    public HandleClient(Socket s) {
        this.client = s;
    }
    @Override
    public void run() {
        // recevoir un message du client
        Scanner in = null;
        try {
            in = new Scanner(client.getInputStream());
        String message = in.nextLine();
        System.out.println("Message reçu du client: " + message);

        // envoyer un message au client
        /**
         * NB : Traitment rah 4ir 9addito mn rasi lannah ma3atix kifax kaytddar mais maxi mohim l dik daraja**/
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        LocalDateTime timestamp = LocalDateTime.now();
        String clientAddress = client.getInetAddress().toString();
        int clientHashCode = clientAddress.hashCode();
        String token = timestamp + "-" + clientHashCode;
        out.println(token);

        // fermeture des sockets
        in.close();
        out.close();
        client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
