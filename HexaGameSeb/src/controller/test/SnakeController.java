package controller.test;

import java.util.List;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import controller.name.BoardgameController;
import model.jeu.MyCases;
import model.test.Snake;

public class SnakeController {
	public BoardgameController boardController = new BoardgameController();

	public void makeMove(Snake snake,List<List<MyCases>> boardList) {
		List<MyCases> snakeBody = snake.getSnakeBody();
		MyCases myCases = snakeBody.get(snakeBody.size()-1);
		
		myCases.setListAdjacentBox(boardController.getAdjacentBox(myCases, boardList));
		MyCases nextCases = pickRandomMyCase(snakeBody,myCases);
		snakeBody.add(0,nextCases);
	}
	

	public MyCases pickRandomMyCase(List<MyCases> snakeBody ,MyCases myCases) {
		Double rdm = Math.random();
		MyCases myCasesToReturn = null;
		List<MyCases> listAdjacentCases = myCases.getListAdjacentBox();
		for (MyCases caseBody : snakeBody) {
			if(listAdjacentCases.contains(caseBody)) {
				listAdjacentCases.remove(caseBody);
			}
		}

		Double size = (double) listAdjacentCases.size();
		Double ecart =  1 / size;
		
		for (int i = 0; i < size; i++) {
			double intervalAvant = ecart * (i-1);
			double interval = ecart * i;
			if(rdm >= intervalAvant && rdm < interval ) {
				myCasesToReturn = listAdjacentCases.get(i);
			}
		} 
		if(myCasesToReturn == null) {
			myCasesToReturn = listAdjacentCases.get(0);
		}else {

		}
		return myCasesToReturn;
	}
	
	
	public void changeColorBodySnake(Snake snake) {
		List<MyCases> body = snake.getSnakeBody();
		Integer rmdInt1 = (int) (Math.random()*200+Math.random()*55);
		Integer rmdInt2 = (int) (Math.random()*200+Math.random()*55);
		Integer rmdInt3 = (int) (Math.random()*200+Math.random()*55);

		for (MyCases myCases : body) {
			//Color colorSelected = new Color(Display.getDefault(), 0, 255, 0);

			Color colorSelected = new Color(Display.getDefault(), rmdInt1, rmdInt2, rmdInt3);
			myCases.getCanvas().setBackground(colorSelected);
		}

	}
	
	
	public void removeLastCases(Snake snake, Integer limite) {
		List<MyCases> snakeBody = snake.getSnakeBody();
		int size = snakeBody.size();
		if(size > limite) {
			MyCases myCasesToDelete = snakeBody.get(0);
			myCasesToDelete.getCanvas().setBackground(new Color(Display.getDefault(), 255,255,255));
			snakeBody.remove(myCasesToDelete);
		}
	}
}
