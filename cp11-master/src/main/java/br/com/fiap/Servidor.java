package br.com.fiap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    private static final int PORT = 12345;
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Aguardando conexão...");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Cliente conectado!");

            executor.execute(new HandleRequest(clientSocket));
        }
    }

    private static class HandleRequest implements Runnable {
        private final Socket socket;

        HandleRequest(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ORACLE_FIAP");
                EntityManager entityManager = entityManagerFactory.createEntityManager();

                ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

                String idProduto = input.readLine();

                System.out.println("ID do produto recebido: " + idProduto); // Adicionando esta linha para verificar o ID recebido

                Produto produto = produtoDAO.buscarPorId(Integer.parseInt(idProduto));

                if (produto != null) {
                    output.println(produto.toString());
                } else {
                    output.println("Produto não encontrado.");
                }

                socket.close();
            } catch (IOException e) {
                System.err.println("Erro: Não foi possível ler a requisição do cliente.");
                e.printStackTrace();
            }
        }
    }
}