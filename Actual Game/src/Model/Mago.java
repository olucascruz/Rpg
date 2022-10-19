package Model;

public class Mago extends Personagem implements ComportamentoMagico {
	
	public Mago(String nome) {
		super(nome);
	}

	@Override
	public String invisibilidade(String inimigo) {
		return getNome() + " ficou invisível, sendo assim não atingido pelo " + inimigo;
	}

	@Override
	public String ultraRapidez(String inimigo) {
		return getNome() + " usou sua ultra rapidez contra o " + inimigo;
	}

}
