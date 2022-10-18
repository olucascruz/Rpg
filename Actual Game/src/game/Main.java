package game;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;

public class Main {
	public static void main(String[] args) {

		// Personagens
		Cavaleiro cavaleiro = new Cavaleiro("XXLucazXX", 10, 70);
		Mago mago = new Mago("Felix", 100, 60);
		Dragao dragao = new Dragao("Bruto", 100, 30);
		
		Jogo jogo = new Jogo(cavaleiro, mago, dragao);
	}
}