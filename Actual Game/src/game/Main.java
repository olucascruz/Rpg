package game;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;

public class Main {
	public static void main(String[] args) {

		// Personagens
		Cavaleiro cavaleiro = new Cavaleiro("Maximus");
		Mago mago = new Mago("Felix");
		Dragao dragao = new Dragao("Bruto");
		
		Jogo jogo = new Jogo(cavaleiro, mago, dragao);
	}
}