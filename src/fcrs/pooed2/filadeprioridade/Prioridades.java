/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.filadeprioridade;

/**
 *
 * @author Josimar Junior
 */
public enum Prioridades {
    GESTANTE(1, "Gestante"), IDOSO(2, "Idoso(a)"), CAIXA_RAPIDO(3, "Caixa Rápido"), CAIXA_NORMAL(4, "Caixa Normal");
    
    int nivel;
    String nomePrioridade;
     Prioridades(int nivel, String nomePrioridade) {
        this.nivel = nivel;
        this.nomePrioridade = nomePrioridade;
    }
     
     public int getNivel() {
         return nivel;
     }
     
     public String getNomePrioridade() {
         return nomePrioridade;
     }
}
