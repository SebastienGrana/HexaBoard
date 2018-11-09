package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.name.BoardgameController;
import controller.name.CasesController;
import controller.test.SnakeController;
import model.jeu.MyCases;
import model.jeu.Pion;
import model.jeu.Terrain;
import model.jeu.TypeTerrain;
import model.test.Snake;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class MainWindowDrawer {

	public static final int WIDTH = 73;
	public static final int HEIGHT = 72;
	public int rectx ;
	public int recty;
	public int rectHeight;
	public int rectWidth;
	public Color boxColor;
	public List<List<MyCases>> boardList = new ArrayList<>();
	public Button btnSetColorBlue;
	public Button btnSetColorRed;
	public Button btnSetColorRandom;
	public Button btnResetBoard;
	public int gridHeight = 10;
	public int gridWidth = 10;

	public BoardgameController boardController = new BoardgameController();
	public CasesController casesController = new CasesController();
	public SnakeController snakeController = new SnakeController();
	protected Shell shlHexagameseb;
	

	public Snake snake = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindowDrawer window = new MainWindowDrawer();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHexagameseb.open();
		shlHexagameseb.layout();
		while (!shlHexagameseb.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHexagameseb = new Shell();
		shlHexagameseb.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		shlHexagameseb.setMinimumSize(new Point(500, 500));
		shlHexagameseb.setSize(750, 500);
		shlHexagameseb.setText("HexaGameSeb");
		shlHexagameseb.setLayout(null);
		
		Label lblTitleMainBoard = new Label(shlHexagameseb, SWT.NONE);
		lblTitleMainBoard.setBounds(336, 7, 73, 15);
		lblTitleMainBoard.setText("MAIN BOARD");

		Canvas canvas_boardGame = new Canvas(shlHexagameseb, SWT.NONE);
		canvas_boardGame.setBounds(100, 28, 573, 423);

		Canvas canvas_preview = new Canvas(shlHexagameseb, SWT.NONE);
		canvas_preview.setBounds(10, 147, WIDTH, HEIGHT);
		drawInPreview(canvas_preview);

		btnSetColorBlue = new Button(shlHexagameseb, SWT.NONE);
		btnSetColorBlue.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnSetColorBlue.setBounds(10, 225, 30, 25);
		btnSetColorBlue.setText("Blue");

		btnSetColorRed = new Button(shlHexagameseb, SWT.NONE);
		btnSetColorRed.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnSetColorRed.setBounds(53, 225, 30, 25);
		btnSetColorRed.setText("Red");

		btnSetColorRandom = new Button(shlHexagameseb, SWT.NONE);
		btnSetColorRandom.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		btnSetColorRandom.setBounds(8, 256, 75, 25);
		btnSetColorRandom.setText("RANDOM");

		drawCanvasGrid(canvas_boardGame);

		btnResetBoard = new Button(shlHexagameseb, SWT.NONE);
		btnResetBoard.setBounds(10, 116, 75, 25);
		btnResetBoard.setText("Reset");

		setOnclickOnColorBtn(canvas_preview);
		MyCases myCases = boardList.get(5).get(5);
		myCases.getCanvas().setBackground(new Color(Display.getDefault(), 125, 125, 125));
		
		Button btnMakeMoveSnake = new Button(shlHexagameseb, SWT.BORDER);
		btnMakeMoveSnake.setBounds(8, 341, 75, 25);
		btnMakeMoveSnake.setText("NEXT");
		btnMakeMoveSnake.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(snake == null) {
					List<MyCases> snakeBody = new ArrayList<>();
					MyCases myCases = boardList.get(5).get(5);
					snakeBody.add(myCases);
					snake = new Snake(snakeBody);
				}
				snakeController.makeMove(snake,boardList);
				// snakeController.removeLastCases(snake, 3);
				snakeController.changeColorBodySnake(snake);
				snake.getSnakeBody().get(0).getCanvas().setBackground(new Color(Display.getDefault(), 125, 125, 125));
			}
		});	
		
		setAdjacentCases();
	}
	


	private void setAdjacentCases( ) {
		for (List<MyCases> list : boardList) {
			for (MyCases myCases : list) {
				List<MyCases> adjacentBox = boardController.getAdjacentBox(myCases, boardList);
				myCases.setListAdjacentBox(adjacentBox);
			}
		}		
	}

	private void setOnclickOnColorBtn(Canvas canvas_preview) {
		Display display = Display.getDefault();
		Color colorB = new Color(display, 0,0,255);
		Color colorR = new Color(display, 255,0,0);
		Color colorN = new Color(display, 255,255,255);
		btnSetColorBlue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas_preview.setBackground(colorB);
				boxColor = colorB;
			}
		});		
		btnSetColorRed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas_preview.setBackground(colorR);
				boxColor = colorR;


			}
		});		
		btnSetColorRandom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Integer rmdInt1 = (int) (Math.random()*200+Math.random()*55);
				Integer rmdInt2 = (int) (Math.random()*200+Math.random()*55);
				Integer rmdInt3 = (int) (Math.random()*200+Math.random()*55);

				Color colorRandom = new Color(display, rmdInt1, rmdInt2, rmdInt3);
				canvas_preview.setBackground(colorRandom);
				System.out.println("RGB : " + rmdInt1 + " " +rmdInt2+ " " +rmdInt3);
				boxColor = colorRandom;
			}
		});		

		btnResetBoard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (List<MyCases> list : boardList) {
					for (MyCases myCases : list) {
						myCases.getCanvas().setBackground(colorN);
					}
				}
			}
		});	

	}

	private void drawInPreview(Canvas canvas_preview) {

		canvas_preview.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawRectangle(
						10, // x
						10, // y
						50, // width
						50); // height
			}
		});
	}

	private void drawCanvasGrid(Canvas canvas_boardGame) {
		canvas_boardGame.setVisible(false);
		Display display = Display.getDefault();
		Rectangle rect = canvas_boardGame.getBounds();
		rectHeight = rect.height/gridHeight;
		rectWidth = rect.width/gridWidth;
		rectx = rect.x;
		recty = rect.y;
		int k =0;

		for (int i = 0; i < gridHeight; i++) {
			List<MyCases> row = new ArrayList<>();
			for (int j = 0; j < gridWidth; j++) {
				MyCases myCases = getNewMyCases(k);
				setOnClickOnCanvas(display, myCases);
				row.add(myCases);
				if(j  != gridWidth ) {
					rectx += rectWidth;
				}
				k++;
			}				
			setRowSize(rect, i);
			boardList.add(row);
		}
	}

	private void setRowSize(Rectangle rect, int i) {
		if(i%2 == 1) {
			if(i  != rectHeight ) {
				recty += rectHeight;
				rectx=rect.x;
			}else {
				recty=rect.y;
			}
		}else {
			if(i  != rectHeight ) {
				recty += rectHeight;
				rectx=rect.x+(rect.x/3);
			}else {
				recty=rect.y;
			}
		}
	}

	private MyCases getNewMyCases(int id) {
		MyCases myCase = new MyCases();
		Canvas caseCanvas = new Canvas(shlHexagameseb, SWT.NONE);
		caseCanvas.setBounds(rectx, recty, rectWidth, rectHeight);

		caseCanvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawRectangle(
						0, // x
						0, // y
						rectWidth, // width
						rectHeight); // height
			}
		});
		//caseCanvas.setBackground(new Color(Display.getDefault(), 255,255,255));
		myCase.setCanvas(caseCanvas);
		myCase.setId(id);
		casesController.configMyCases(myCase);
		//System.out.println("id new case =" + id);
		return myCase;
	}

	private void setOnClickOnCanvas(Display display, MyCases myCases) {
		myCases.getCanvas().addMouseListener(new MouseListener(){
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				for (MyCases adjacentCases : myCases.getListAdjacentBox()) {
					Color colorSelected = new Color(display, 0, 255, 0);
					adjacentCases.getCanvas().setBackground(colorSelected);
				}
			}
			@Override
			public void mouseDown(MouseEvent e) {
				myCases.getCanvas().setBackground(boxColor);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				//caseCanvas.setBackground(new Color(display, 125,0,0));
			}       
		});
	}
}
