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
					showImage("img/cavaleiro_ataca_mago.png", cavaleiro.atacar(" mago."));
				} else {
					showImage("img/cavaleiro_ataca_dragao.png", cavaleiro.atacar(" dragão."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("img/cavaleiro_defende_mago.png", cavaleiro.defender(" mago."));
				} else {
					showImage("img/cavaleiro_defende_dragao.png", cavaleiro.defender(" dragão."));
				}
			break;
			case 3:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("img/cavaleiro_salta_mago.png", cavaleiro.saltar(" mago."));
				} else {
					showImage("img/cavaleiro_salta_dragao.png", cavaleiro.saltar(" dragão."));
				}
			break;
			case 4:
				showImage("img/cavaleiro_pocao.png", cavaleiro.usarItem());
			break;
			case 5:
				showImage("img/cavaleiro_pocao.png", cavaleiro.guardarItem());
			break;
			case 6:
				showImage("img/cavaleiro_anda.png", cavaleiro.andar());
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
					showImage("img/mago_invisivel_cavaleiro.png", mago.invisibilidade(" cavaleiro."));
				} else {
					showImage("img/mago_invisivel_dragao.png", mago.invisibilidade(" dragão."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o mago está lutando?\n\n"
						+ "1 - cavaleiro\n"
						+ "2 - Dragão\n"));
				
				if(op2 == 1) {
					showImage("img/mago_veloz_cavaleiro.png", mago.ultraRapidez(" cavaleiro."));
				} else {
					showImage("img/mago_veloz_dragao.png", mago.ultraRapidez(" dragão."));
				}
			break;
			case 3:
				showImage("img/mago_pocao.png", mago.usarItem());
			break;
			case 4:
				showImage("img/mago_pocao.png", mago.guardarItem());
			break;
			case 5:
				showImage("img/mago_anda.png", mago.andar());
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
					showImage("img/dragao_morde_mago.png", dragao.morder(" mago."));
				} else {
					showImage("img/dragao_morde_cavaleiro.png", dragao.morder(" cavaleiro."));
				}
			break;
			case 2:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o dragão está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Cavaleiro\n"));
				
				if(op2 == 1) {
					showImage("img/dragao_fogo_mago.png", dragao.atirarFogo(" mago."));
				} else {
					showImage("img/dragao_fogo_cavaleiro.png", dragao.atirarFogo(" cavaleiro."));
				}
			break;
			case 3:
				op2 = Integer.parseInt(JOptionPane.showInputDialog("Contra quem o cavaleiro está lutando?\n\n"
						+ "1 - Mago\n"
						+ "2 - Cavaleiro\n"));
				
				if(op2 == 1) {
					showImage("img/dragao_voa_mago.png", dragao.voar(" mago."));
				} else {
					showImage("img/dragao_voa_cavaleiro.png", dragao.voar(" cavaleiro."));
				}
			break;
			case 4:
				showImage("img/dragao_pocao.png", dragao.usarItem());
			break;
			case 5:
				showImage("img/dragao_pocao.png", dragao.guardarItem());
			break;
			case 6:
				showImage("img/dragao_anda.png", dragao.andar());
			break;
		}
	}
	
	public void showImage(String src, String descricao) {
		JOptionPane.showMessageDialog(null, descricao, "Ação do personagem",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource(src)));
	}
	
}
