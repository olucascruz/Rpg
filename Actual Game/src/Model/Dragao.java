package Model;

public class Dragao extends Personagem implements ComportamentoFeroz {

	public Dragao(String nome) {
		super(nome);
	}

	@Override
	public String atirarFogo(String inimigo) {
		return getNome() + " atirou fogo contra o " + inimigo;
	}

	@Override
	public String voar(String inimigo) {
		return getNome() + " voou, se desviando dos ataques do " + inimigo;
	}

	@Override
	public String morder(String inimigo) {
		return getNome() + " mordeu o " + inimigo;
	}

}
