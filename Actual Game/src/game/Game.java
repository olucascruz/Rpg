package game;
import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;

public class Game extends Canvas implements Runnable{
	
	Cavaleiro cavaleiro = new Cavaleiro("XXLucazXX", 10, 70);
	Mago mago = new Mago("Felix", 100, 60);
	Dragao dragao = new Dragao("Bruto", 100, 30);
	
	// Po��o - Mago - Drag�o
	boolean pocao_ativo = false;
	boolean dragao_ativo = false;
	boolean mago_ativo = true;
	
	public Game(){
		this.setPreferredSize(new Dimension(700, 500));
	}
	
	public String updateStatusDoJogo(int opcao) {
		
		// Poções
		if(opcao == 0) {
			return "img/usou_pocao.png";
		} else if(opcao == 1) {
			return "img/guardou_pocao.png";
		} else if(opcao == 2) {
			return "img/sem_pocao.png";
		}
		
		return "";
	}
	
	public void DrawImg(Graphics g, String path, int x, int y, int w, int h) {
		g.drawImage(new ImageIcon(getClass().getResource(path)).getImage(),
				x,
				y,
				w,
				h, null);
	}
	
	public void Map(Graphics g) {
		
		if(mago_ativo) {
			// Floresta de Noite
			DrawImg(g,mago.getBackground(), 0, 0, 700, 500);
			// Mago
			DrawImg(g, mago.getImage(), mago.getPosition_x(), mago.getPosition_y(), 600, 420);
			
			// Vidas
			if(mago.getVida() == 3) {
				DrawImg(g, "img/coracao_cheio.png", 480, -20, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 540, -20, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 600, -20, 600, 420);
			} else if(mago.getVida() == 2){
				DrawImg(g, "img/coracao_cheio.png", 480, -20, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 540, -20,600, 420);
				DrawImg(g, "img/coracao_vazio.png", 600, -20, 600, 420);
			} else if(mago.getVida() == 1) {
				DrawImg(g, "img/coracao_cheio.png",  480, -20, 600, 420);
				DrawImg(g, "img/coracao_vazio.png", 540, -20, 600, 420);
				DrawImg(g, "img/coracao_vazio.png", 600, -20, 600, 420);
			}
			/*
			// Rapidez
			DrawImg(g, mago.getRapidez(), 30, 40, 600, 420);
			
			// Invis�vel
			DrawImg(g, mago.getInvisivel(), mago.getPosition_x(), mago.getPosition_y(), 600, 420);
			*/
		} else if(dragao_ativo) {
			// Deserto
			DrawImg(g, dragao.getBackground(), 0, 0, 700, 500);
			
			// Drag�o
			DrawImg(g, dragao.getImage(), dragao.getPosition_x(), dragao.getPosition_y(), 600, 420);
			
			// Vidas
			if(dragao.getVida() == 3) {
				DrawImg(g, "img/coracao_cheio.png", 480, -60, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 540, -60, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 600, -60, 600, 420);
			} else if(dragao.getVida() == 2){
				DrawImg(g, "img/coracao_cheio.png", 480, -60, 600, 420);
				DrawImg(g, "img/coracao_cheio.png", 540, -60, 600, 420);
				DrawImg(g, "img/coracao_vazio.png", 600, -60, 600, 420);
			} else if(dragao.getVida() == 1) {
				DrawImg(g, "img/coracao_cheio.png", 480, -60, 600, 420);
				DrawImg(g, "img/coracao_vazio.png", 540, -60, 600, 420);
				DrawImg(g, "img/coracao_vazio.png", 600, -60, 600, 420);
			}
			/*
			// Mordida
			DrawImg(g, dragao.getMordida(), 30, 20, 600, 420);
			
			// Rajada de fogo
			DrawImg(g, dragao.getFogo(), 30, 20, 600, 420);
			*/
		} else if(pocao_ativo) {
			// Floresta de dia
			DrawImg(g, cavaleiro.getBackground(), 0, 0, 700, 500);
			
			// Po��o
			DrawImg(g, "img/pocao.png", 100, 50, 600, 450);
		}
		
		// Cavaleiro
		DrawImg(g, cavaleiro.getImagePlayer(), cavaleiro.getPosition_x(), cavaleiro.getPosition_y(), 600, 420);
	
		// Vidas
		if(cavaleiro.getVida() == 3) {
			DrawImg(g, "img/coracao_cheio.png", -10, 40, 600, 420);
			DrawImg(g, "img/coracao_cheio.png", 50, 40, 600, 420);
			DrawImg(g, "img/coracao_cheio.png", 110, 40, 600, 420);
		} else if(cavaleiro.getVida() == 2){
			DrawImg(g, "img/coracao_cheio.png", -10, 40, 600, 420);
			DrawImg(g, "img/coracao_cheio.png", 50, 40, 600, 420);
			DrawImg(g, "img/coracao_vazio.png", 110, 40, 600, 420);
		} else if(cavaleiro.getVida() == 1) {
			DrawImg(g, "img/coracao_cheio.png", -10, 40, 600, 420);
			DrawImg(g, "img/coracao_vazio.png", 50, 40, 600, 420);
			DrawImg(g, "img/coracao_vazio.png", 110, 40, 600, 420);
		}
		/*
		// Atacar
		DrawImg(g, cavaleiro.getAtacar(), 30, 20, 600, 420);
	
		// Defender
		DrawImg(g, cavaleiro.getDefender(), 30, 20, 600, 420);
		*/
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
			
		Map(g);
		g.dispose();
		bs.show();
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			render();
		}
		
	}
	
}