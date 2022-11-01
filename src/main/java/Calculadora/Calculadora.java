package Calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements ICalculadora {
    static String ServiceName = "CalculadoraService";

    protected Calculadora() throws RemoteException {
        super();
    }

    @Override
    public double Somar(double a, double b) {
        return a+b;
    }

    @Override
    public double Subtrair(double a, double b) {
        return a-b;
    }

    @Override
    public double Multiplicar(double a, double b) {
        return a*b;
    }

    @Override
    public double Dividir(double a, double b) {
        return a/b;
    }
}
