package exo3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculateurSonsorInterface extends Remote {

    double CalculTva (double tva) throws RemoteException; //salaire brute * taux de TVA

    double Calcul_Salaire_net (double tva) throws RemoteException;  //salaire brute — (salaire brute * taux de TVA)

    double lire_Salaire_brute () throws RemoteException;  //retourne le salaire brute
}
