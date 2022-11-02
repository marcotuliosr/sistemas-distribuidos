/**
 * Created by marcotuliosr
 * Date : 9/2/2022}
 * Time : 9:47 AM
 * Project Name : sistemas-distribuidos
 */

package Projeto05;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket(4545);
            System.out.println("Servidor esperando conexão.......");
            String envio;
            DatagramPacket recebe = new DatagramPacket(new byte[512], 512);
            while (true) {
                envio = "";
                s.receive(recebe);
                System.out.print("Mensagem recebida na porta: " + recebe.getPort());
                System.out.println();
                System.out.print("Mensagem recebida: ");


                for (int i = 0; i < recebe.getLength(); i++) {
                    System.out.print((char) recebe.getData()[i]);
                }

                System.out.println();

                DatagramPacket resp = new DatagramPacket(recebe.getData(), recebe.getLength(), recebe.getAddress(), recebe.getPort());
                s.send(resp);
            }

        } catch (
                IOException e) {
            throw new RuntimeException(e); //

        }
    }
}