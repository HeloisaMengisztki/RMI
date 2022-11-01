package Calculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {
    double Somar(double a, double b) throws RemoteException;
    double Subtrair(double a, double b) throws RemoteException;
    double Multiplicar(double a, double b) throws RemoteException;
    double Dividir(double a, double b) throws RemoteException;
}
