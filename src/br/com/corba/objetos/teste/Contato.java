package br.com.corba.objetos.teste;

import java.io.Serializable;

/**
 *
 */
public class Contato implements Serializable {
    private final String nome;
    private final String email;
    private final String telefone;
    
    public Contato(String nome, String email, String telefone) {
        this.nome     = nome;
        this.email    = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }
    
    @Override
    public String toString() {
        return this.nome + " - " + this.email + " " + this.telefone;
    }
}