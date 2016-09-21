package fcrs.pooed2.abstratas;

import fcrs.pooed2.exception.BarraFuraoException;
import fcrs.pooed2.exception.FilaVaziaException;

/**
*
* @author Josimar Junior
* @see Operacao
*/
public interface Fila {

	void enfileirar(Operacao operacao) throws BarraFuraoException;
    Operacao desenfileirar() throws FilaVaziaException;
    Operacao frente() throws FilaVaziaException;
    boolean isEmpty();
    int size();
}
