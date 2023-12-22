package exo3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculateurSonsor extends UnicastRemoteObject implements CalculateurSonsorInterface {

    double salaireBrute;

    public CalculateurSonsor(double salaireBrute) throws RemoteException {
        this.salaireBrute = salaireBrute;
    }

    @Override
    public double CalculTva(double tva) throws RemoteException {
        return salaireBrute*0.3; //salaire brute * taux de TVA
    }

    @Override
    public double Calcul_Salaire_net(double tva) throws RemoteException {
        return salaireBrute* (1-tva); //salaire brute — (salaire brute * taux de TVA)
    }


    @Override
    public double lire_Salaire_brute() throws RemoteException {
        return salaireBrute; //retourne le salaire brute
    }
}
