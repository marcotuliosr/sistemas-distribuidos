package Datagrama;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Servidor {
    public static void main (String[] args ) {
        try{
            InetAddress par = InetAddress.getByName("224.0.0.3");
            InetAddress impar = InetAddress.getByName("224.0.0.5");

            MulticastSocket multicastSocket = new MulticastSocket();

            for(int i = 0; i < 101; i++) {
                if(i % 2 == 0) {
                    String msg = String.valueOf(i);
                    byte[] output = msg.getBytes();
                    DatagramPacket packet = new DatagramPacket(output, msg.length(), par, 3456);
                    multicastSocket.send(packet);
                    System.out.println("Mensagem enviada: " + i);
                } else {
                    String msg = String.valueOf(i);
                    byte[] output = msg.getBytes();
                    DatagramPacket packet = new DatagramPacket(output, msg.length(), impar, 3456);
                    multicastSocket.send(packet);
                    System.out.println("Mensagem enviada: " + i);
                }
            }

            multicastSocket.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
