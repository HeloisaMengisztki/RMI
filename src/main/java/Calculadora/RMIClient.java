package Calculadora;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        String hostName = "localhost";
        String serviceName = Calculadora.ServiceName;

        try{
            ICalculadora calculadora = (ICalculadora) Naming.lookup("rmi://"+hostName+"/"+serviceName);
            Scanner in = new Scanner(System.in);

            int opcao;
            do {
                showMenu();
                opcao = leInt(in,"informe opção: ");

                switch (opcao) {
                    case 1 -> somar(calculadora, in);
                    case 2 -> subtrair(calculadora, in);
                    case 3 -> multiplicar(calculadora, in);
                    case 4 -> dividir(calculadora, in);
                    case 0 -> System.out.println("ENCERRANDO");
                    default -> System.out.println("Opcao nao encontrada");
                }
            }while (opcao != 0);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void dividir(ICalculadora calculadora, Scanner in) throws RemoteException {
        double a = leDouble(in,"Informe o primeiro numero: ");
        double b = leDouble(in, "Informe o segundo numero: ");
        System.out.println("RESULTADO = " + calculadora.Dividir(a, b));
    }

    private static void multiplicar(ICalculadora calculadora, Scanner in) throws RemoteException {
        double a = leDouble(in,"Informe o primeiro numero: ");
        double b = leDouble(in, "Informe o segundo numero: ");
        System.out.println("RESULTADO = " + calculadora.Multiplicar(a, b));
    }

    private static void subtrair(ICalculadora calculadora, Scanner in) throws RemoteException {
        double a = leDouble(in,"Informe o primeiro numero: ");
        double b = leDouble(in, "Informe o segundo numero: ");
        System.out.println("RESULTADO = " + calculadora.Subtrair(a, b));
    }

    private static void somar(ICalculadora calculadora, Scanner in) throws RemoteException {
        double a = leDouble(in,"Informe o primeiro numero: ");
        double b = leDouble(in, "Informe o segundo numero: ");
        System.out.println("RESULTADO = " + calculadora.Somar(a, b));
    }

    private static void showMenu() {
        System.out.println("----------- MENU -----------");
        System.out.println("SOMAR: 1");
        System.out.println("SUBTRAIR: 2");
        System.out.println("MULTIPLICAR: 3");
        System.out.println("DIVIDIR: 4");
        System.out.println("sair: 0");
        System.out.println("----------------------------");
    }

    private static int leInt(Scanner in, String mensagem) {
        boolean conseguiu = false;
        int valor = 0;

        do{
            try {
                System.out.println(mensagem);
                valor = in.nextInt();
                conseguiu = true;
            }catch (Exception e){
                System.out.println("Número inválido");
                in.nextLine();
            }
        }while (!conseguiu);

        return valor;
    }

    private static double leDouble(Scanner in, String mensagem) {
        boolean conseguiu = false;
        double valor = 0;

        do{
            try {
                System.out.println(mensagem);
                valor = in.nextDouble();
                conseguiu = true;
            }catch (Exception e){
                System.out.println("Número inválido");
                in.nextLine();
            }
        }while (!conseguiu);

        return valor;
    }
}
