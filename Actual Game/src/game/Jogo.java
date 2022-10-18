package game;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Jogo {
	
	public Cavaleiro cavaleiro;
	public Mago mago;
	public Dragao dragao;
	public static Scanner scan;

	public Jogo(Cavaleiro cavaleiro, Mago mago, Dragao dragao) {
		this.cavaleiro = cavaleiro;
		this.mago = mago;
		this.dragao = dragao;
		
		scan = new Scanner(System.in);
		controlarAcoes();
	}
	
	public void controlarAcoes() {
		while(true) {
			print("Selecione um personagem:\n");
			print("1 - Cavaleiro");
			print("2 - Mago");
			print("3 - Dragao");
			print("Opcao: ");
			
			int op = scan.nextInt();
			
			switch(op) {
				case 1:
					controlarAcoesDosPersonagens(cavaleiro);
				break;
				case 2:
					controlarAcoesDosPersonagens(mago);
				break;
				case 3:
					controlarAcoesDosPersonagens(dragao);
				break;
			}
		}
	}

	public void controlarAcoesDosPersonagens(Cavaleiro cavaleiro) {
		print("O que o cavaleiro " + cavaleiro + " vai fazer?\n");
		print("1 - Atacar");
		print("2 - Defender");
		print("3 - Usar ítem\n");
		print("Opção: ");
		
		int op = scan.nextInt();
	}
	
	public void controlarAcoesDosPersonagens(Mago mago) {
		print("O que o mago " + mago + " vai fazer?\n");
		print("1 - Ficar invisível");
		print("2 - Usar ultra velocidade\n");
		print("Opção: ");
		
		int op = scan.nextInt();
	}

	public void controlarAcoesDosPersonagens(Dragao dragao) {
		print("O que o cavaleiro " + dragao + " vai fazer?\n");
		print("1 - Morder");
		print("2 - Voar");
		print("3 - Atirar fogo\n");
		print("Opção: ");
		
		int op = scan.nextInt();
	}
	
	public static void print(String texto) {
		System.out.println(texto);
	}
	
	public void showImage() {
		JOptionPane.showMessageDialog(null, "O personagem fez alguma coisa", "Ação",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("img/dragao.png")));
	}
	
}
