package game;

import java.awt.*;

import javax.swing.JFrame;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;

public class Main {
	public static void main(String[] args) {

		// Personagens
		Cavaleiro cavaleiro = new Cavaleiro("XXLucazXX", 10, 70);
		Mago mago = new Mago("Felix", 100, 60);
		Dragao dragao = new Dragao("Bruto", 100, 30);

		Game game = new Game();
		JFrame frame = new JFrame("Sopro de ogo");
		String filePath = "game_song.wav";
		musicStuff musicObject = new musicStuff();

		musicObject.playMusic(filePath);
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new Thread(game).start();
	}
}