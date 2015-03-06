package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Canvas extends JPanel implements KeyListener, Runnable{

	private final static int Width=400;
	private final static int Height=300;
	private final static int TileWidth=16;
	private final static int TileHeight=16;
	public final static int Row=15;
	public final static int Col=20;
	private final static int XOffset=(Width-Col*TileWidth)/2;
	private final static int YOffset=(Height-Row*TileHeight)/2;
	
	private Snake snake;
	private Food food;
	
	public Canvas(){

		snake = new Snake();
		food =new Food();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		drawBackground(g);
		drawSnake(g);
		drawFood(g);
	}
	
	public void drawSnake(Graphics g){
		g.setColor(Color.GREEN);
		for(int i=0;i<this.snake.getLength();i++){
			Body body=snake.getBody(i);
			g.fillRect(body.col*TileWidth+XOffset, body.row*TileHeight+YOffset, TileWidth, TileHeight);
		}
	}
	public void drawFood(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(food.getCol()*TileWidth+XOffset, food.getRow()*TileHeight+YOffset, TileWidth, TileHeight);
	}
	
	public void drawBackground(Graphics g){
		g.setColor(Color.BLACK);
		for(int i=0;i<Col;i++){
			for(int j=0;j<Row;j++){
				g.drawRect(XOffset+i*TileWidth, YOffset+j*TileHeight, TileWidth, TileHeight);
			}
		}
	}
	
	public boolean eatFood(){
		return (snake.getBody(0).col==food.getCol())&&(snake.getBody(0).row==food.getRow());
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			snake.move();
			if(eatFood()){
				snake.eat(food);
				food=new Food();
			}
			repaint();
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			snake.setmDirection(DIRECTION.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.setmDirection(DIRECTION.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.setmDirection(DIRECTION.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setmDirection(DIRECTION.RIGHT);
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
