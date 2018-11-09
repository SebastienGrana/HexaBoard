package model.test;

import java.util.ArrayList;
import java.util.List;

import model.jeu.MyCases;

public class Snake {

	
	private List<MyCases> snakeBody = new ArrayList<>();

	public Snake(List<MyCases> snakeBody) {
		super();
		this.snakeBody = snakeBody;
	}

	public List<MyCases> getSnakeBody() {
		return snakeBody;
	}

	public void setSnakeBody(List<MyCases> snakeBody) {
		this.snakeBody = snakeBody;
	}
	
	
}
