package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            IO.println("Connecté au serveur calculatrice.");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            try {
                int x;
                do {

                        x = Integer.parseInt(IO.readln("Veuillez saisir un entier (0 pour quitter) : "));
                        dos.writeInt(x);
                        if (x != 0) {
                            int resultat = dis.readInt();
                            IO.println("Résultat reçu du serveur (" + x + " * 5) = " + resultat);
                        }
                } while (x != 0);
            } catch (Exception _) {

            }

            IO.println("Arrêt de la communication.");

            dis.close();
            dos.close();
            socket.close();
        } catch (IOException _) {
        }
    }
}