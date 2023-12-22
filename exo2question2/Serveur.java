package exo2question2;

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

                // haxno zdna f question 2 : zdna la classe HandleClient
                new Thread(new HandleClient(client)).start();
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
