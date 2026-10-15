package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            IO.println("Serveur calculatrice en attente de connexion...");

            Socket socket = serverSocket.accept();
            IO.println("Un client est connecté.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            int x;

            while ((x = dis.readInt()) != 0) {
                IO.println("Valeur reçue du client : " + x);
                int resultat = x * 5; // Calcul du produit x * 5
                IO.println("Calcul effectué : " + x + " * 5 = " + resultat);
                dos.writeInt(resultat); // Envoi du résultat au client
            }
            IO.println("Valeur 0 reçue : Fermeture de la connexion...");

            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();
        } catch (IOException _) {
        }
    }
}