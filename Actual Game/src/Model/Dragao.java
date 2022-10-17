package Model;

public class Dragao extends Personagem implements ComportamentoFeroz {
	
	private String image = "img/dragao.png";
	private String background = "img/deserto.png";
	private String mordida = "img/mordida.png";
	private String fogo = "img/rajada_de_fogo.png";

	public Dragao(String nome, int position_x, int position_y) {
		super(nome, position_x, position_y);
	}

	public String getImage() {
		return image;
	}

	public String getBackground() {
		return background;
	}

	public String getMordida() {
		return mordida;
	}

	public String getFogo() {
		return fogo;
	}


	@Override
	public void atirarFogo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morder() {
		// TODO Auto-generated method stub
		
	}

}
