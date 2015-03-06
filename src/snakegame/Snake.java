package snakegame;

import java.util.*;


enum DIRECTION {UP,DOWN,LEFT,RIGHT;}

public class Snake{
	private List<Body> mBody;
	private DIRECTION mDirection;
	//private boolean state;
	
	public Snake(){
		//state=true;
		mBody=new ArrayList<Body>();
		reset();
	}
	
	public List<Body> getmBody() {
		return mBody;
	}
	
	public void eat(Food food){
		Body newbody=new Body(food.getRow(),food.getCol());
		mBody.add(0, newbody);
	}

	public void setmBody(List<Body> mBody) {
		this.mBody = mBody;
	}

	public DIRECTION getmDirection() {
		return mDirection;
	}

	public void setmDirection(DIRECTION mDirection) {
		switch(this.mDirection){
		case UP:
			if(mDirection==DIRECTION.DOWN){
				return;
			}
			break;
		case DOWN:
			if(mDirection==DIRECTION.UP){
				return;
			}
			break;
		case LEFT:
			if(mDirection==DIRECTION.RIGHT){
				return;
			}
			break;
		case RIGHT:
			if(mDirection==DIRECTION.LEFT){
				return;
			}
			break;
		}
		this.mDirection = mDirection;
	}

	public void changeDirection(DIRECTION newDirection){
		this.mDirection=newDirection;
	}
	
	public void reset(){
		//state=true;
		mBody.clear();
		mBody.add(new Body(7,4));
		mBody.add(new Body(7,3));
		mBody.add(new Body(7,2));
		mBody.add(new Body(7,1));
		
		mDirection=DIRECTION.RIGHT;
	}
	
	public int getLength(){
		return mBody.size();
	}
	
	public Body getBody(int index){
		return this.mBody.get(index);
	}
	
	public void move(){
		Body last=mBody.remove(getLength()-1);
		switch(mDirection){
			case UP:
				last.row=getBody(0).row-1;
				if(last.row<0){
					last.row=Canvas.Row-1;
				}
				last.col=getBody(0).col;
				mBody.add(0, last);
				break;
			case DOWN:
				last.row=getBody(0).row+1;
				if(last.row==Canvas.Row){
					last.row=0;
				}
				last.col=getBody(0).col;
				mBody.add(0, last);
				break;
			case LEFT:
				last.row=getBody(0).row;
				last.col=getBody(0).col-1;
				if(last.col<0){
					last.col=Canvas.Col-1;
				}
				mBody.add(0, last);
				break;
			case RIGHT:
				last.row=getBody(0).row;
				last.col=getBody(0).col+1;
				if(last.col==Canvas.Col){
					last.col=0;
				}
				mBody.add(0, last);
				break;
		}
	}
}
