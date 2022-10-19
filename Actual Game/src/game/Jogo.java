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
			
			int op = Integer.parseInt(JOptionPane.showInputDialog("Selecione um personagem:\n\n"
					+ "1 - Cavaleiro\n"
					+ "2 - Mago\n"
					+ "3 - Dragão\n"));
			
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
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar?\n\n"
					+ "1 - Sim\n"
					+ "2 - Não\n"));
			
			if(op == 2) {
				break;
			}
		}
	}

	public void controlarAcoesDosPersonagens(Cavaleiro cavaleiro) {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("O que o cavaleiro" + cavaleiro.getNome() + " vai fazer?\n\n"
				+ "1 - Atacar\n"
				+ "2 - Defender\n"
				+ "3 - Saltar\n"
				+ "4 - Usar ítem\n"
				+ "5 - Guardar ítem\n"
				+ "6 - Andar\n"));
		int op2;
		
		switch(op) {
			case 1:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("", cavaleiro.atacar(" mago."));
				} else {
					showImage("", cavaleiro.atacar(" dragão."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("", cavaleiro.defender(" mago."));
				} else {
					showImage("", cavaleiro.defender(" dragão."));
				}
			break;
			case 3:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("", cavaleiro.saltar(" mago."));
				} else {
					showImage("", cavaleiro.saltar(" dragão."));
				}
			break;
			case 4:
				showImage("", cavaleiro.usarItem());
			break;
			case 5:
				showImage("", cavaleiro.guardarItem());
			break;
			case 6:
				showImage("", cavaleiro.andar());
			break;
		}
	}
	
	public void controlarAcoesDosPersonagens(Mago mago) {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("O que o mago " + mago.getNome() + " vai fazer?\n\n"
				+ "1 - Ficar invisível\n"
				+ "2 - Usar ultra velocidade\n"
				+ "3 - Usar ítem\n"
				+ "4 - Guardar ítem\n"
				+ "5 - Andar\n"));
		int op2;
		
		switch(op) {
			case 1:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o mago está lutando?\n\n"
						+ "1 - Cavaleiro\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("", mago.invisibilidade(" cavaleiro."));
				} else {
					showImage("", mago.invisibilidade(" dragão."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o mago está lutando?\n\n"
						+ "1 - cavaleiro\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("", mago.ultraRapidez(" cavaleiro."));
				} else {
					showImage("", mago.ultraRapidez(" dragão."));
				}
			break;
			case 3:
				showImage("", mago.usarItem());
			break;
			case 4:
				showImage("", mago.guardarItem());
			break;
			case 5:
				showImage("", mago.andar());
			break;
		}
	}

	public void controlarAcoesDosPersonagens(Dragao dragao) {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("O que o cavaleiro" + cavaleiro.getNome() + " vai fazer?\n\n"
				+ "1 - Morder\n"
				+ "2 - Atirar bola de fogo\n"
				+ "3 - Voar\n"
				+ "4 - Usar ítem\n"
				+ "5 - Guardar ítem\n"
				+ "6 - Andar\n"));
		int op2;
		
		switch(op) {
			case 1:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o dragão está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Cavaleiro\n"));
				
				if(op2 == 1) {
					showImage("", dragao.morder(" mago."));
				} else {
					showImage("", dragao.morder(" cavaleiro."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o dragão está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Cavaleiro\n"));
				
				if(op2 == 1) {
					showImage("", dragao.atirarFogo(" mago."));
				} else {
					showImage("", dragao.atirarFogo(" cavaleiro."));
				}
			break;
			case 3:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Cavaleiro\n"));
				
				if(op2 == 1) {
					showImage("", dragao.voar(" mago."));
				} else {
					showImage("", dragao.voar(" cavaleiro."));
				}
			break;
			case 4:
				showImage("", dragao.usarItem());
			break;
			case 5:
				showImage("", dragao.guardarItem());
			break;
			case 6:
				showImage("", dragao.andar());
			break;
		}
	}
	
	public void showImage(String src, String descricao) {
		JOptionPane.showMessageDialog(null, descricao, "Ação do personagem",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource(src)));
	}
	
}
