package Calculadora;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerCalculadora {
    public static void main(String[] args) {
        try{
            Registry r = LocateRegistry.createRegistry(1099);

            Calculadora calculadora = new Calculadora();
            Naming.rebind(Calculadora.ServiceName, calculadora);
            System.out.println("Calculadora Server is running...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
