package exo2question1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Serveur {
    public static void main(String[] args) {
        ServerSocket serveur = null;

        try {
            // le port est fourni comme argument
            serveur = new ServerSocket(1459);

            while (true) {
                // attendre une nouvelle connexion
                Socket client = serveur.accept();

                // commencer le traitement
                System.out.println("Nouvelle demande interceptée");

                // recevoir un message du client
                Scanner in = new Scanner(client.getInputStream());
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serveur != null && !serveur.isClosed()) {
                    serveur.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
