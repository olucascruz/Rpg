package Model;

public class Cavaleiro extends Personagem implements ComportamentoHeroico{
	
	private String ImagePlayer = "img/cavaleiro.png";
	private String background = "img/floresta_dia.png";
	private String castelo = "img/castelo.png";
	private String atacar = "img/espada.png";
	private String defender = "img/escudo.png";
	private boolean saltando;
	private boolean atacando;
	private boolean defendendo;
	private boolean possuiPocao;

	public Cavaleiro(String nome, int position_x, int position_y) {
		super(nome, position_x, position_y);
		
		possuiPocao = false;
	}

	public String getImagePlayer() {
		return ImagePlayer;
	}

	public String getBackground() {
		return background;
	}

	public String getAtacar() {
		return atacar;
	}

	public String getDefender() {
		return defender;
	}

	public String getCastelo() {
		return castelo;
	}

	public boolean isSaltando() {
		return saltando;
	}

	public void setSaltando(boolean saltando) {
		this.saltando = saltando;
	}

	public boolean isAtacando() {
		return atacando;
	}

	public void setAtacando(boolean atacando) {
		this.atacando = atacando;
	}

	public boolean isDefendendo() {
		return defendendo;
	}

	public void setDefendendo(boolean defendendo) {
		this.defendendo = defendendo;
	}

	public boolean isPossuiPocao() {
		return possuiPocao;
	}

	public void setPossuiPocao(boolean possuiPocao) {
		this.possuiPocao = possuiPocao;
	}

	@Override
	public void atacar(Personagem p) {
		// TODO Auto-generated method stub
		p.setVida(getVida()-1);
	}

	@Override
	public void defender() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saltar() {
		// TODO Auto-generated method stub
		
	}

}
