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
public class Gestante extends Operacao {

    public Gestante(String dono) {
        super(dono, GeraSenha.geraSenhaGestante());
    }

    @Override
    public int getPrioridade() {
        return Prioridades.GESTANTE.getNivel();
    }
    
    @Override
    public String getNomePrioridade() {
        return Prioridades.GESTANTE.getNomePrioridade();
    }

}
