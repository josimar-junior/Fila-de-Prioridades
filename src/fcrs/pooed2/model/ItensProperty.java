/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.model;

import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Josimar Junior
 */
public class ItensProperty {
    
    private SimpleStringProperty senha;
    private SimpleStringProperty prioridade;
    private SimpleStringProperty nomeDono;

    public ItensProperty(String senha, String prioridade, String nomeDono) {
        this.senha = new SimpleStringProperty(senha);
        this.prioridade = new SimpleStringProperty(prioridade);
        this.nomeDono = new SimpleStringProperty(nomeDono);
    }

    public String getSenha() {
        return senha.get();
    }

    public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public String getPrioridade() {
        return prioridade.get();
    }

    public void setPrioridade(String prioridade) {
        this.prioridade.set(prioridade);
    }

    public String getNomeDono() {
        return nomeDono.get();
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono.set(nomeDono);
    }
    
}
