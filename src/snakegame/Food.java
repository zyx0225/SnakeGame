package snakegame;
import java.util.*;

public class Food {
	private int col;
	private int row;
	private boolean state;
	
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	public Food(){
		Random rnd=new Random();
		this.state=true;
		this.col=rnd.nextInt(Canvas.Col);
		this.row=rnd.nextInt(Canvas.Row);
	}
}
