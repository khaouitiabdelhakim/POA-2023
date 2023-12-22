package exo3;

import java.io.IOException;
import java.rmi.Naming;

class Client {

    public static void main(String[] argv) throws IOException {

        if (argv.length != 2) {
            System.out.println("Usage : java Client <nombre><operation>");
            System.exit(1);
        }

        // operation = 1: CalculTva, 2: lire_Salaire_brute

        double valeur = Double.parseDouble(argv[0]);
        int operation = Integer.parseInt(argv[1]);

        try {

            // acompleter ...
            CalculateurSonsorInterface sonsor = (CalculateurSonsorInterface) Naming.lookup("rmi://services.ensias.ma:2456/sonsor");
            // Assuming 'operation' is an int variable
            switch (operation) {
                case 1:
                    sonsor.CalculTva(0.3);
                    break;
                case 2:
                    sonsor.lire_Salaire_brute();
                    break;
                case 3:
                    sonsor.Calcul_Salaire_net(0.3);
                    break;
                default:
                    // Default case code here
                    break;
            }

            // afficher le Salaire net
            double net = sonsor.lire_Salaire_brute();
            System.out.println("Salaire Net: "+net);

        } catch (Exception e) {
            System.out.println("Erreur d'accés 4 un objet distant");
            System.out.println(e.toString());
        }
    }
}
