/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.filadeprioridade;

import fcrs.pooed2.abstratas.GeraSenha;
import fcrs.pooed2.abstratas.Operacao;
/**
 *
 * @author Josimar Junior
 */
public class CaixaRapido extends Operacao {

    public CaixaRapido(String dono) {
        super(dono, GeraSenha.geraSenhaCaixaRapido());
    }

    @Override
    public int getPrioridade() {
        return Prioridades.CAIXA_RAPIDO.getNivel();
    }
    
    @Override
    public String getNomePrioridade() {
        return Prioridades.CAIXA_RAPIDO.getNomePrioridade();
    }

}
