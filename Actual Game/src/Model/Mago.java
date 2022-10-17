package Model;

public class Mago extends Personagem implements ComportamentoMagico {
	
	private String image = "img/mago.png";
	private String background = "img/floresta_noite.png";
	private String invisivel = "img/mago_invisivel.png";
	private String rapidez = "img/superrapidez.png";
	
	public Mago(String nome, int position_x, int position_y) {
		super(nome, position_x, position_y);
	}

	public String getImage() {
		return image;
	}

	public String getBackground() {
		return background;
	}

	public String getInvisivel() {
		return invisivel;
	}

	public String getRapidez() {
		return rapidez;
	}

	@Override
	public void invisibilidade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ultraRapidez() {
		// TODO Auto-generated method stub
		
	}

}
