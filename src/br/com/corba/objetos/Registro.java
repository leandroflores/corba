package br.com.corba.objetos;

import java.io.Serializable;

/**
 * <p>Classe <b>Registro</b>.</p>
 * <p>Classe responsavel por representar um Registro de Requisicao.</p>
 */
public class Registro implements Serializable {
    private final String id;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param id Id do Registro.
     */
    public Registro(String id) {
        this.id = id;
    }
    
    /**
     * Metodo responsavel por retornar o Id do Registro.
     * @return Id do Registro.
     */
    public String getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Registro #" + this.id;
    }
}