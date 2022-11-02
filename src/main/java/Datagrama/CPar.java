package Datagrama;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class CPar {
    public static void main(String[] args) {

        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress dest = InetAddress.getByName("224.0.0.3");

            MulticastSocket multicastSocket = new MulticastSocket(3456);
            multicastSocket.joinGroup(dest);

            byte[] buf = new byte[512];

            DatagramPacket recv = new DatagramPacket(buf, buf.length);

            for (int i = 0; i < 50; i++) {
                multicastSocket.receive(recv);
                String msg = new String(recv.getData());
                System.out.println(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
