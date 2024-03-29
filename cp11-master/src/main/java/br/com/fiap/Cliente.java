package br.com.fiap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Informe o ID do produto: ");
            String idProduto = teclado.readLine();

            output.println(idProduto);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String resposta = input.readLine();

            System.out.println("Informações sobre o produto: ");
            System.out.println(resposta);

            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Erro: Não foi possível conectar ao servidor.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro: Não foi possível ler a resposta do servidor.");
            e.printStackTrace();
        }
    }
}