/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.filadeprioridade;

import fcrs.pooed2.abstratas.Imprimivel;

/**
 *
 * @author Josimar Junior
 */
public abstract class CentralDeImpressao {
    public static void imprimir(Imprimivel imprimivel){
        imprimivel.imprimir();
    }
}
