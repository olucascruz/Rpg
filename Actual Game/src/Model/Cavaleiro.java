package Model;

public class Cavaleiro extends Personagem implements ComportamentoHeroico{

	public Cavaleiro(String nome) {
		super(nome);
	}

	@Override
	public String atacar(String inimigo) {
		return getNome() + " atacou o " + inimigo;
	}

	@Override
	public String defender(String inimigo) {
		return getNome() + " se defendeu do " + inimigo;
	}

	@Override
	public String saltar(String inimigo) {
		return getNome() + " saltou sobre o " + inimigo;
	}

}
