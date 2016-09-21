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
public class Idoso extends Operacao {

    public Idoso(String dono) {
        super(dono, GeraSenha.geraSenhaIdoso());
    }

    @Override
    public int getPrioridade() {
        return Prioridades.IDOSO.getNivel();
    }

    @Override
    public String getNomePrioridade() {
        return Prioridades.IDOSO.getNomePrioridade();
    }

    
}
