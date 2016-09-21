/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcrs.pooed2.filadeprioridade;

import fcrs.pooed2.abstratas.Fila;
import fcrs.pooed2.abstratas.Imprimivel;
import fcrs.pooed2.abstratas.Operacao;
import fcrs.pooed2.exception.BarraFuraoException;
import fcrs.pooed2.exception.FilaVaziaException;
import fcrs.pooed2.model.ItensProperty;
import fcrs.pooed2.util.Mensagens;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que implementa as interfaces Fila e Imprimivel
 * @author Josimar Junior
 */
public class FilaDePrioridades implements Fila, Imprimivel {

	private NoPrioridade cauda;
	private NoPrioridade frente;
	private int tam;
	private static ObservableList<ItensProperty> listaPrioridade = FXCollections
			.observableArrayList();

	/**
	 * Método construtor
	 * */
	public FilaDePrioridades() {
		frente = new NoPrioridade(null, null, null, 0); // Instancia a frente com tudo null e prioridade 0
		cauda = new NoPrioridade(frente, null, null, 0);// Instancia a cauda, passando como anterior a frente
		frente.setNext(cauda);//seta a variável cauda como próxima da frente
	}

	
	/**
	 * Método enfileirar, responsável por inserir os dados na fila
	 * @param operacao - parâmetro do tipo Operacao
	 * @see Operacao
	 * @exception BarraFuraoException
	 * */
	@Override
	public void enfileirar(Operacao operacao) throws BarraFuraoException {
		if (operacao instanceof Furao) { // Verifica se o que está sendo passado por parâmetro é um furão, se for ele lança a exceção
			throw new BarraFuraoException("A pessoa de nome "
					+ operacao.getDono() + " é um furão!");
		}

		NoPrioridade np; // Cria uma variável do tipo NoPrioridade

		if (isEmpty()) { // Se estiver vazio, seta na frente
			np = new NoPrioridade(frente, frente.getNext(), operacao,
					operacao.getPrioridade());
			frente.getNext().setPrev(np);
			frente.setNext(np);
		} else { 
			boolean inseriu = false; // Variável do tipo booleana para saber se inseriu na fila
			NoPrioridade aux = frente.getNext(); // Variável auxilixar para receber a frente
			while (aux != cauda) { // Percorre enquanto a frente for diferente da cauda
				if (operacao.getPrioridade() < aux.getPrioridade()) { // Verifica se a prioridade que está sendo passada por parâmetro é menor do que a que está sendo percorrida na fila
					// Se for verdade, insere de acordo com a prioridade
					np = new NoPrioridade(aux.getPrev(), aux, operacao,
							operacao.getPrioridade());
					aux.getPrev().setNext(np);
					aux.setPrev(np);
					inseriu = true; // Falo que inseriu
					break; // Sai do laço
				}
				aux = aux.getNext(); // Percorre a fila
			}
			if (!inseriu) { // Se não insirir, insere na cauda
				np = new NoPrioridade(cauda.getPrev(), cauda, operacao,
						operacao.getPrioridade());
				cauda.getPrev().setNext(np);
				cauda.setPrev(np);
			}
		}
		tam++; // Incrementa o tamanho da fila
	}

	/**
	 * Método responsável por desenfileirar a fila a partir do topo
	 * @return {@link Operacao}
	 * @exception FilaVaziaException
	 * */
	@Override
	public Operacao desenfileirar() throws FilaVaziaException {
		if (isEmpty()) { // Se estiver vazia, lança a exceção
			throw new FilaVaziaException("Fila vazia!");
		}
		Operacao aux = frente.getNext().getOperacao(); // Salva a operação que está no topo
		frente = frente.getNext(); // Seta a frente para a próxima posição
		tam--; // Decrementa o tamanho
		preencherLista(); // Chama o método para preencher a lista
		return aux; // retorna a aux
	}

	/**
	 * Método responsável por retornar a operação que está no topo da fila
	 * @return {@link Operacao}
	 * @exception FilaVaziaException
	 * */
	@Override
	public Operacao frente() throws FilaVaziaException {
		if (isEmpty()) { // Se estiver vazia, lança a exceção 
			throw new FilaVaziaException("Fila vazia!");
		}
		return frente.getNext().getOperacao(); // Retorn o topo da fila
	}

	/**
	 * método responsável por verificar se a fila está vazia ou não
	 * */
	@Override
	public boolean isEmpty() {
		return tam == 0;
	}

	/**
	 * método responsável por retornar o tamanho da fila
	 * */
	@Override
	public int size() {
		return tam;
	}

	/**
	 * Método sobrescrito da interface Imprimivel
	 * */
	@Override
	public void imprimir() {
		try {
			NoPrioridade aux = frente.getNext(); // Variável auxilixar para receber a frente
			String msg = ""; // Variável do tipo String vazia 
			while (aux != cauda) { // Executa enquanto a frente for diferente da cauda
				msg += aux.getOperacao().getDono() + " (" + aux.getPrioridade() // Concatena a msg com o dono e a prioridade
						+ ") | ";
				aux = aux.getNext(); // Passa para o próximo da fila
			}
			Mensagens.mensagemInformacao(msg); // Mostra a mensagem com todos da fila
		} catch (Exception e) {
			Mensagens.mensagemErro(e.getMessage());
		}
	}

	// Esse método serve pra mostrar os dados na tabela, não precisam focar nisso
	public ObservableList<ItensProperty> getListaPrioridade() {
		listaPrioridade.clear();
		preencherLista();
		return listaPrioridade;
	}

	// Esse método serve pra mostrar os dados na tabela, não precisam focar nisso
	private void preencherLista() {
		try {
			NoPrioridade aux = frente.getNext();
			while (aux != cauda) {
				listaPrioridade.add(new ItensProperty(aux.getOperacao()
						.getSenha(), aux.getOperacao().getNomePrioridade(), aux
						.getOperacao().getDono()));
				aux = aux.getNext();
			}
		} catch (Exception e) {
			Mensagens.mensagemErro(e.getMessage());
		}
	}

}
