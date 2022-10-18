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
import Model.Personagem;

public class Game extends Canvas implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Cavaleiro cavaleiro = new Cavaleiro("XXLucazXX", 10, 70);
	Mago mago = new Mago("Felix", 100, 60);
	Dragao dragao = new Dragao("Bruto", 100, 30);
	
	// Po��o - Mago - Drag�o
	int cenas[] = {1, 1, 1};
	int cena_atual = 0;
	Random rand;
	boolean pocao_ativo = true;
	boolean dragao_ativo = false;
	boolean mago_ativo = false;
	
	boolean cena_stand_by = true;
	
	boolean clique_para_continuar = true;
	
	// Op��es do cavaleiro
	boolean cavaleiro_opcoes = false;
	int cavaleiro_opcao = 0;
	
	String acaoCav = "";
	
	public Game(){
		this.setPreferredSize(new Dimension(700, 500));
		this.addKeyListener(this);
		rand = new Random();
	}
	
	public void updateEncontro() {
		cena_atual = rand.nextInt(3);
		
		if(cena_atual == 0) {
			pocao_ativo = true;
			dragao_ativo = false;
			mago_ativo = false;
		} else if(cena_atual == 1) {
			pocao_ativo = false;
			dragao_ativo = true;
			mago_ativo = false;
		} else {
			pocao_ativo = false;
			dragao_ativo = false;
			mago_ativo = true;
		}
	}
	
	public String updateCenaStandBy(int cena) {
		if(cena == 0) {
			return "img/achou_pocao.png";
		} else if(cena == 1) {
			return "img/achou_dragao.png";
		} else if(cena == 2) {
			return "img/achou_mago.png";
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
	
	public void updateOpcoes() {
		// Atualizar o sublinhado
	}
	
	public void controlarAcoesDosPersonagens(Personagem p, String acao) {
		String acaoCav = cavaleiro.getAtacar();
		// M�todos do Luquinhas
		if(p instanceof Cavaleiro) {
			if(acao.equals("andar")) {
				p.andar();
			}else if(acao.equals("usarItem")) {
				p.guardarItem();
			}
			else if(acao.equals("usarItem")) {
				p.usarItem();
			}
			
			if(acao.equals("Atacar")) {
				if(cena_atual == 1) {
					((Cavaleiro) p).atacar(dragao);
					AnimCavaleiro(cavaleiro.getAtacar());
				}
				if(cena_atual == 2) {
					((Cavaleiro) p).atacar(mago);
					AnimCavaleiro(cavaleiro.getAtacar());
				}
				
			}
			
		}else if(p instanceof Mago) {
			if(acao.equals("andar")) {
				p.andar();
			}else if(acao.equals("usarItem")) {
				p.guardarItem();
			}
			else if(acao.equals("usarItem")) {
				p.usarItem();
			}
			
		}else if(p instanceof Dragao){
			if(acao.equals("andar")) {
				p.andar();
			}else if(acao.equals("usarItem")) {
				p.guardarItem();
			}
			else if(acao.equals("usarItem")) {
				p.usarItem();
			}
		}
		
	}
	
	public void AnimCavaleiro(String acao) {
		acaoCav = acao;
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
		
		DrawImg(g, acaoCav, 30, 20, 600, 420);
		
		// Troca de cenas - stand by
		if(cena_stand_by) {
			DrawImg(g, updateCenaStandBy(cena_atual), 0, 0, 700, 500);
		}
		
		// Op��es do Cavaleiro
		if(cavaleiro_opcoes) {
			// Se for a cena da po��o
			if(cena_atual == 0) {
				DrawImg(g, "img/cavaleiro_opcoes_1.png", 0, 0, 700, 500);
				// Sublinhados
				if(cavaleiro_opcao == 0) {
					DrawImg(g, "img/sublinhado.png", 40, 0, 700, 500);
				} else if(cavaleiro_opcao == 1) {
					DrawImg(g, "img/sublinhado.png", 220, 0, 700, 500);
				} else {
					DrawImg(g, "img/sublinhado.png", 400, 0, 700, 500);
				}
			} else {
				DrawImg(g, "img/cavaleiro_opcoes_2.png", 0, 0, 700, 500);
				// Sublinhados
				if(cavaleiro_opcao == 0) {
					DrawImg(g, "img/sublinhado.png", 0, 0, 700, 500);
				} else if(cavaleiro_opcao == 1) {
					DrawImg(g, "img/sublinhado.png", 120, 0, 700, 500);
				} else if(cavaleiro_opcao == 2){
					DrawImg(g, "img/sublinhado.png", 230, 0, 700, 500);
				} else if(cavaleiro_opcao == 3){
					DrawImg(g, "img/sublinhado.png", 330, 0, 700, 500);
				} else if(cavaleiro_opcao == 4){
					DrawImg(g, "img/sublinhado.png", 430, 0, 700, 500);
				}
			}
		}
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
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(cavaleiro_opcoes) {
				if(cavaleiro_opcao > 0) {
					cavaleiro_opcao--;
				}
			}
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(cavaleiro_opcoes) {
				if(cena_atual == 0) {
					if(cavaleiro_opcao < 2) {
						cavaleiro_opcao++;
					}
				} else {
					if(cavaleiro_opcao < 4) {
						cavaleiro_opcao++;
					}
				}
			}
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(cena_stand_by) {
				cena_stand_by = false;
				cavaleiro_opcoes = true;
			} else if(cavaleiro_opcoes) {
				updateEncontro();
				//controlarAcoesDosPersonagens(cavaleiro, "Atacar");
				cena_stand_by = true;
				cavaleiro_opcoes = false;
				cavaleiro_opcao = 0;
			}
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