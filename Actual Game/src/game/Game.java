package game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;
import java.util.Random;

import Model.Cavaleiro;
import Model.Dragao;
import Model.Mago;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Cavaleiro cavaleiro = new Cavaleiro("XXLucazXX", 10, 70);
	Mago mago = new Mago("Felix", 100, 60);
	Dragao dragao = new Dragao("Bruto", 100, 30);
	
	// Poção - Mago - Dragão
	int cenas[] = {1, 1, 1};
	
	boolean clique_para_continuar = true;
	
	public Game(){
		this.setPreferredSize(new Dimension(700, 500));
		this.addKeyListener(this);
		Random rand = new Random();
	}
	
	public void updateEncontro() {
		
	}
	
	public void updateOpcoes() {
		// Atualizar o sublinhado
	}
	
	public void controlarAcoesDosPersonagens() {
		// Métodos do Luquinhas
	}
	
	public void Map(Graphics g) {
		
		/*
		// Floresta de dia
		g.drawImage(new ImageIcon(getClass().getResource(cavaleiro.getBackground())).getImage(),
				0,
				0,
				700,
				500, null);
		*/
		
		// Floresta de Noite
		g.drawImage(new ImageIcon(getClass().getResource(mago.getBackground())).getImage(),
				0,
				0,
				700,
				500, null);
		
		/*
		// Deserto
		g.drawImage(new ImageIcon(getClass().getResource(dragao.getBackground())).getImage(),
				0,
				0,
				700,
				500, null);
		*/
		
		// Cavaleiro
		g.drawImage(new ImageIcon(getClass().getResource(cavaleiro.getImagePlayer())).getImage(),
				cavaleiro.getPosition_x(),
				cavaleiro.getPosition_y(),
				600,
				420, null);
		
		// Vidas
		if(cavaleiro.getVida() == 3) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					-10,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					50,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					110,
					40,
					600,
					420, null);
		} else if(cavaleiro.getVida() == 2){
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					-10,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					50,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					110,
					40,
					600,
					420, null);
		} else if(cavaleiro.getVida() == 1) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					-10,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					50,
					40,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					110,
					40,
					600,
					420, null);
		}
		/*
		// Atacar
		g.drawImage(new ImageIcon(getClass().getResource(cavaleiro.getAtacar())).getImage(),
				30,
				20,
				600,
				420, null);
	
		// Defender
		g.drawImage(new ImageIcon(getClass().getResource(cavaleiro.getDefender())).getImage(),
				30,
				20,
				600,
				420, null);
		*/
		/*
		// Mago
		g.drawImage(new ImageIcon(getClass().getResource(mago.getImage())).getImage(),
				mago.getPosition_x(),
				mago.getPosition_y(),
				600,
				420, null);
		
		// Vidas
		if(mago.getVida() == 3) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					540,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					600,
					-20,
					600,
					420, null);
		} else if(mago.getVida() == 2){
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					540,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					600,
					-20,
					600,
					420, null);
		} else if(mago.getVida() == 1) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					540,
					-20,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					600,
					-20,
					600,
					420, null);
		}
		
		// Rapidez
		g.drawImage(new ImageIcon(getClass().getResource(mago.getRapidez())).getImage(),
				30,
				40,
				600,
				420, null);
		
		// Invisível
		g.drawImage(new ImageIcon(getClass().getResource(mago.getInvisivel())).getImage(),
				mago.getPosition_x(),
				mago.getPosition_y(),
				600,
				420, null);
		*/
		
		
		// Dragão
		g.drawImage(new ImageIcon(getClass().getResource(dragao.getImage())).getImage(),
				dragao.getPosition_x(),
				dragao.getPosition_y(),
				600,
				420, null);
		
		// Vidas
		if(dragao.getVida() == 3) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					540,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					600,
					-60,
					600,
					420, null);
		} else if(dragao.getVida() == 2){
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					540,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					600,
					-60,
					600,
					420, null);
		} else if(dragao.getVida() == 1) {
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_cheio.png")).getImage(),
					480,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					540,
					-60,
					600,
					420, null);
			g.drawImage(new ImageIcon(getClass().getResource("img/coracao_vazio.png")).getImage(),
					600,
					-60,
					600,
					420, null);
		}
		/*
		// Mordida
		g.drawImage(new ImageIcon(getClass().getResource(dragao.getMordida())).getImage(),
				30,
				20,
				600,
				420, null);
		
		// Rajada de fogo
		g.drawImage(new ImageIcon(getClass().getResource(dragao.getFogo())).getImage(),
				30,
				20,
				600,
				420, null);
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
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
		
	}
	
	
	
	@Override
	public void run() {
		
		while(true) {
			render();
			try {
				Thread.sleep(1000/60);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
}