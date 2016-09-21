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
public class NoPrioridade {

    private NoPrioridade prev;
    private NoPrioridade next;
    private Operacao operacao;
    private int prioridade;

    public NoPrioridade() {
    }

    public NoPrioridade(NoPrioridade prev, NoPrioridade next, Operacao operacao, int prioridade) {
        this.prev = prev;
        this.next = next;
        this.operacao = operacao;
        this.prioridade = prioridade;
    }

    public NoPrioridade getNext() {
        return next;
    }

    public void setNext(NoPrioridade next) {
        this.next = next;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public NoPrioridade getPrev() {
        return prev;
    }

    public void setPrev(NoPrioridade prev) {
        this.prev = prev;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "NoPrioridade{" + "operacao=" + operacao.getDono() + ", prioridade=" + prioridade + '}';
    }

}
