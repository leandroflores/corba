package br.com.corba.servidor;

import br.com.corba.objetos.ObjetoCorba;
import br.com.corba.objetos.teste.Contato;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>Classe <b>Servidor3</b>.</p>
 */
public class Servidor3 {
    private static final String SERVER_NAME = "Servidor_3";
    private static final String HOST_NAME   = "127.0.0.1";
    private static final short  PORT_NUMBER = 8005;
    
    public static void main(String[] args) throws IOException {
        try {
            
            // Inicia o Socket:
            Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
            
            // Inicia OutputStream do Objeto:
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            // Instancia o Objeto a ser inserido:
            ObjetoCorba objeto = new ObjetoCorba("Objeto_3", new Contato("MARIA", "maria@gmail.com", "(44)3333-3333"), SERVER_NAME);
                               // Envia o Objeto CORBA ao Servico de Nomes:
                               outputStream.writeObject(objeto);
                               outputStream.flush();
            
            ObjectInputStream  inputStream  = new ObjectInputStream(socket.getInputStream());
        }catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOST_NAME);
            System.exit(1);
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + HOST_NAME);
            System.exit(1);
        }
    }
}