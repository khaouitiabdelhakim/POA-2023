package exo3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {
            CalculateurSonsor server = new CalculateurSonsor(10000);
            LocateRegistry.createRegistry(2456);
            Naming.rebind("rmi://services.ensias.ma:2456/sonsor",server);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
