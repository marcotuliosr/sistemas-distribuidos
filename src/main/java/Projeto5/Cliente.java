/**
 * Created by marcotuliosr
 * Date : 9/2/2022}
 * Time : 9:47 AM
 * Project Name : sistemas-distribuidos
 */

package Projeto5;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress dest = InetAddress.getByName("localhost");

            String envio;

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("> ");
            envio = teclado.readLine();

            while (!envio.equalsIgnoreCase("")) {
                byte[] buffer = envio.getBytes();
                DatagramPacket msg = new DatagramPacket(buffer, buffer.length, dest, 4545);
                s.send(msg);
                DatagramPacket resposta = new DatagramPacket(new byte[512], 512);
                s.receive(resposta);


                for (int i = 0; i < resposta.getLength(); i++) {
                    System.out.print((char) resposta.getData()[i]);
                }
                System.out.println();
                System.out.print("> ");
                envio = teclado.readLine();
            }

            s.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

