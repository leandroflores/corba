package br.com.corba;

import br.com.corba.objetos.ObjetoCorba;
import br.com.corba.objetos.Registro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * <p>Classe <b>ServicoNome</b>.</p>
 * <p>Classe responsavel por definir o Servico de Nomes.</p>
 * <p>Socket: Porta = 8005. 
 */
public class ServicoNome {
    private static final short  PORT_NUMBER  = 8005;
    private static final HashMap<String, ObjetoCorba> HASH = new HashMap<>();
    
    
    /**
     * Metodo responsavel por retornar o Objeto pelo seu Identificador.
     * @param  id Id do Objeto.
     * @return Objeto.
     */
    public static ObjetoCorba utilizar(String id) {
        return HASH.get(id);
    }
    
    /**
     * Metodo responsavel por registrar um Objeto na HASH.
     * @param id Id do Objeto CORBA.
     * @param object Objeto CORBA.
     */
    public static void registrar(String id, ObjetoCorba object) {
        if (!HASH.containsKey(id))
            HASH.put(id, object);
    }
    
    /**
     * Metodo principal do Servico CORBA.
     * @param args Argumentos.
     * @throws IOException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Servico de Nomes iniciado...");
        
        try {
            // Inicializa o Socket do Servidor:
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            
            System.out.println("Esperando pelos Clientes...");
            while (true) {
                // Espera o Socket do Cliente:
                Socket socket = serverSocket.accept();
                                
                // Inicializa Output/Input do Objeto:
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream  inputStream  = new ObjectInputStream(socket.getInputStream());
                
                // Recebe o Objeto do Cliente:
                Registro readObject = (Registro) inputStream.readObject();
                
                if (readObject instanceof ObjetoCorba) {
                    ObjetoCorba objeto = (ObjetoCorba) readObject;
                    HASH.put(objeto.getId(), objeto);
                    System.out.println(HASH);
                }else {
                    ObjetoCorba objeto = HASH.get(readObject.getId());
                    outputStream.writeObject(objeto);
                    outputStream.flush();
                }                
            }
        }catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "+ PORT_NUMBER + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}