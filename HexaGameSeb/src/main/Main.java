package main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import model.jeu.Boardgame;
import model.jeu.Clan;
import model.jeu.MyCases;
import model.jeu.Pion;
import model.jeu.Terrain;
import model.jeu.TypeTerrain;

import java.util.Random;

public class Main {

	public static Pion pion1;	
	public static Pion pion2 ;
	public static Boardgame boardgame;
	public static Terrain terrainType1;
	public static Terrain terrainType2;
	public static Terrain terrainType3;
	public static Clan blueClan;
	public static Clan redClan;

	private static Boolean init() {	
		System.out.println("Debut Init");	
		Boolean isInitOk = false;

		blueClan = new Clan(0, "Blue Clan", "Blue");
		redClan = new Clan(1, "Red Clan", "Red");


		pion1 = new Pion(0, "Soldat", 50.0, 1.0, blueClan, true, null);
		pion2 = new Pion(1, "Soldat", 50.0, 1.0, redClan, true, null);

		Integer nbCases = 10;
		initBoardgame(nbCases);



		isInitOk = true;
		System.out.println("Fin Init");
		return isInitOk ;

	}

	private static Boolean initBoardgame(Integer nbCases) {	
		System.out.println("Debut Init BoardGame");
		Boolean isInitOk = false;
		Random rnd = new Random();

		boardgame = new Boardgame(0);

		terrainType1 = new Terrain(0, "Grass",TypeTerrain.HERBE.getColor());
		terrainType2 = new Terrain(1, "Water", TypeTerrain.EAU.getColor());
		terrainType3 = new Terrain(2, "Pierre", TypeTerrain.PIERRE.getColor());

		ArrayList<Terrain> listTerrain = new ArrayList<Terrain>();
		listTerrain.add(terrainType1);
		listTerrain.add(terrainType2);
		listTerrain.add(terrainType3);

		ArrayList<ArrayList<MyCases>> listCasesXY = new ArrayList<>();
		ArrayList<MyCases> listCasesX = new ArrayList<>();
		int k = 0 ;
		for(int i = 0 ; i <= nbCases ; i++) {

			for(int j= 0 ; j <= nbCases ; j++){
				Integer idRandomTerrain = rnd.nextInt(listTerrain.size());
				Terrain randomTerrain = listTerrain.get(idRandomTerrain);
				MyCases newCase = new MyCases(k, randomTerrain, null, null ,null);

				listCasesX.add(newCase);
				k++;
			}
			listCasesXY.add(listCasesX);
		}
		boardgame.setListOfCases(listCasesXY);
		isInitOk = true;	
		System.out.println("Fin Init BoardGame");
		return isInitOk ;
	}

	private static void placePions(Pion myPion, Integer posX, Integer poxY) {

		ArrayList<MyCases> listCasesX = new ArrayList<>();

		listCasesX = boardgame.getListOfCases().get(posX);

		MyCases cases = listCasesX.get(poxY);

		cases.setPionOfCase(myPion);
		myPion.setPosition(cases);

	}

	private static void printPion() {
		String nameTerrainPion1 = pion1.getPosition().getTypeTerrain().getName();
		System.out.println("Le pion : \""+ pion1.getName()+" "+pion1.getClan().getColor() +"\" est sur la case : "+ pion1.getPosition().getId()+" sur le terrain de nom : " + nameTerrainPion1 );

		String nameTerrainPion2 = pion2.getPosition().getTypeTerrain().getName();
		System.out.println("Le pion : \""+ pion2.getName()+" "+pion2.getClan().getColor() +"\" est sur la case : "+ pion2.getPosition().getId()+" sur le terrain de nom : " + nameTerrainPion2 );
	}



	public static List<Color> colors;
	public static  int colorIndex;


	@SuppressWarnings("unused")
	private static Composite createLayer(Composite parent) {

		Composite layer = new Composite(parent, SWT.NONE);
		layer.setLayout(new FillLayout());
		for (int i = 0; i < 10; i++) {
			Label label = new Label(layer, SWT.NONE);
			label.setText("I go \u26F7");
			label.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseDown(MouseEvent e) {
					Shell shell =Display.getDefault().getActiveShell();
					MessageBox dialog =
							new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("My info");
					dialog.setMessage("Do you really want to do this?");
					dialog.open();

				}

			});
		}
		Button removeButton = new Button(layer, SWT.PUSH);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				layer.dispose();
				parent.requestLayout();
			}
		});


		GridData d2 = new GridData(SWT.FILL, SWT.TOP, true, false);
		layer.setLayoutData(d2);
		if (colorIndex > colors.size()-1 ) {
			colorIndex = 0;
		}
		layer.setBackground(colors.get(colorIndex++));
		return layer;
	}

	public static void main(String[] args) {

		System.out.println("Debut");	

		init();

		placePions(pion1, 1, 5);
		placePions(pion2, 10, 5);


		printPion();

		System.out.println("FIN");	

	}

}
