/**
 * Created by marcotuliosr
 * Date : 9/1/2022}
 * Time : 11:14 PM
 * Project Name : sistemas-distribuidos
 */

package Projeto3;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try {
            Socket conexao = new Socket("127.0.0.1", 2001);
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            String linha;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("> ");
                linha = teclado.readLine();
                saida.writeUTF(linha);
                linha = entrada.readUTF();
                if (linha.equalsIgnoreCase("")) {
                    System.out.println("Conexao encerrada");
                    break;
                }
                System.out.println(linha);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}