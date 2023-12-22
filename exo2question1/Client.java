package exo2question1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // création de socket : les infos du serveur sont fournies comme argument
            Socket client = new Socket("localhost",1459);

            // accéder au flux dE/S
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);

            // envoyer un message au serveur
            out.println("Bonjour");

            //recevoir la réponse et afficher le message
            String reponse = in.nextLine();
            System.out.println("message recu du serveur: "+reponse);
            //fermer les flux et la sockets*

            in.close();
            out.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}