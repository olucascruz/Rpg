package Model;

public class Personagem implements ComportamentoNormal{
	
	private String nome;
	private int vida = 3;
	private int position_x;
	private int position_y;
	
	public Personagem(String nome, int position_x, int position_y) {
		this.nome = nome;
		this.position_x = position_x;
		this.position_y = position_y;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getVida() {
		return this.vida;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	@Override
	public void andar() {
		System.out.println(getNome() + " foi embora.");
	}

	@Override
	public void guardarItem() {
		System.out.println(getNome() + " guardou o ítem.");
	}

	@Override
	public void usarItem() {
		System.out.println(getNome() + " usou o ítem.");
	}

}
