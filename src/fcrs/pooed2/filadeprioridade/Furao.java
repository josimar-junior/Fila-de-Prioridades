/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.filadeprioridade;

import fcrs.pooed2.abstratas.Operacao;

/**
 *
 * @author Josimar Junior
 */
public class Furao extends Operacao{

    public Furao(String dono) {
        super(dono, null);
    }

    @Override
    public int getPrioridade() {
        return -1;
    }

    @Override
    public String getNomePrioridade() {
        return null;
    }

   
}
