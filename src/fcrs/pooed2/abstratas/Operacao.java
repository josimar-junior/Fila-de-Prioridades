package fcrs.pooed2.abstratas;

/**
 *
 * @author Josimar Junior
 */
public abstract class Operacao implements Prioridade {
	private String dono;
	private String senha;

	public Operacao() {
	}

	public Operacao(String dono, String senha) {
		this.dono = dono;
		this.senha = senha;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return dono;
	}

}