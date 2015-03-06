package snakegame;

import java.awt.*;

import javax.swing.*;

public class Board extends JFrame{
	private final static int Width=400;
	private final static int Height=300;
	
	private Canvas canvas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board=new Board("SnakeGame");
	}
	public Board(String title){
		//constructor for board
		super(title);
		this.setSize(Width,Height);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		canvas=new Canvas();
		this.add(canvas);
		this.addKeyListener(canvas);
		Thread threadCanvas=new Thread(canvas);
		threadCanvas.start();
		
	}
	
	
	
}
