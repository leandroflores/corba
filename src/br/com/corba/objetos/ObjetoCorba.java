package br.com.corba.objetos;

import java.io.Serializable;

/**
 * <p>Classe <b>ObjetoCorba</b>.</p>
 * <p>Classe responsavel por representar um Objeto Corba.</p>
 * @see br.com.corba.objetos.Registro
 */
public class ObjetoCorba extends Registro implements Serializable {
    private final Object objeto;
    private final String servidor;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param id Id do Objeto.
     * @param object Objeto a ser salvo.
     * @param servidor Nome do Servidor.
     */
    public ObjetoCorba(String id, Object object, String servidor) {
        super(id);
        this.objeto   = object;
        this.servidor = servidor;
    }
    
    /**
     * Metodo responsavel por retornar o Objeto.
     * @return Objeto.
     */
    public Object getObjeto() {
        return this.objeto;
    }
    
    /**
     * Metodo responsavel por retornar o Nome do Servidor.
     * @return Nome do Servidor.
     */
    public String getServidor() {
        return this.servidor;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + this.objeto + "[" + this.servidor + "]";
    }
}