package ChamadaProcedimentosRemotos;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcServer extends UnicastRemoteObject implements Calc{
    public CalcServer() throws RemoteException {
        super();
    }

    public int getSoma(int a, int b) throws RemoteException{
        System.out.println(" Calculando a soma de " + a + " + "+ b);
        return a + b;
    }
    public int getSubtracao(int a, int b) throws RemoteException{
        System.out.println(" Calculando a subtracao de " + a + " - "+ b);
        return a - b;
    }
    public int getMultiplicacao(int a, int b) throws RemoteException{
        System.out.println(" Calculando a multiplicacao de " + a + " * "+ b);
        return a * b;
    }
    public double getDivisao(int a, int b) throws RemoteException{
        System.out.println(" Calculando a divisao de " + a + " / "+ b);
        return (double) a / b;
    }

}

