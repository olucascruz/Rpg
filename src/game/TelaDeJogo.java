package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TelaDeJogo extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Image bgInicial;
	final int WIDTH = 500;
	final int HEIGHT = 500;
	String state = "MENU";
	
	public TelaDeJogo() {
		JButton button = new JButton();
		int buttonWidth = 80;
		int buttonHeight = 40;
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		button.setText("START");
		button.setLocation(WIDTH/2 - buttonWidth, HEIGHT-100);
		setBackground (Color.GRAY);
		loadImage();
		setLayout(new FlowLayout());
        this.setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(button);
        setVisible(true);
      
      
	}
	
	public void paint(Graphics g)    
	  {
		 
	   if(state.equals("MENU")) {
		   g.drawImage(bgInicial, 0, 0, this);
	   }else{
		   g.clearRect(0, 0, WIDTH, HEIGHT);
	   }
	  }
	
	
	public void loadImage() {
		System.out.println(new File("/Rpg/src/img/dragon.png").getPath() );
		try {
			bgInicial = ImageIO.read(new File(".//res//img//dragon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setState("GAME");
	}
	
	public void setState(String state) {
		this.state = state;
		System.out.println("Jogo");
	}

}
