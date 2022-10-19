package Model;

public class Personagem implements ComportamentoNormal{
	
	private String nome;
	
	public Personagem(String nome) {
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public String andar() {
		return getNome() + " foi embora.";
	}

	@Override
	public String guardarItem() {
		return getNome() + " guardou o �tem.";
	}

	@Override
	public String usarItem() {
		return getNome() + " usou o �tem.";
	}

}
