package br.com.corba.cliente;

import br.com.corba.objetos.Registro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>Classe <b>Cliente</b>.</p>
 * <p>Classe responsavel por representar um Cliente do Servico de Nomes.</p>
 */
public class Cliente {
    private static final String HOST_NAME   = "127.0.0.1";
    private static final short  PORT_NUMBER = 8005;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            
            // Inicia Socket:
            Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
            
            // Inicia OutputStream do Objeto:
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                               
                               // Envia o Id do Objeto ao Servico de Nomes: 
                               outputStream.writeObject(new Registro("Objeto_1"));
                               outputStream.flush();
                               
            // Recebe o Objeto do Servico de Nomes:
            ObjectInputStream  inputStream  = new ObjectInputStream(socket.getInputStream());
            System.out.println(inputStream.readObject());            
        }catch (UnknownHostException exception) {
            System.err.println("Don't know about host " + HOST_NAME);
            System.exit(1);
        }catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + HOST_NAME);
            System.exit(1);
        }
    }
}