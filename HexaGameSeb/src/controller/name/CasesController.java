package controller.name;

import org.eclipse.swt.graphics.Color;

import model.jeu.MyCases;
import model.jeu.Terrain;
import model.jeu.TypeTerrain;

public class CasesController {

	
	
	public void configMyCases(MyCases myCases) {
		myCases.setPionOfCase(null);

		Double randVal =  Math.random() ;
/*
		if (randVal < 0.25) {
			Color colorTerrain = TypeTerrain.TERRE.getColor();
			myCases.setTypeTerrain(new Terrain(0, "Terre",colorTerrain));
			myCases.getCanvas().setBackground(colorTerrain);
		}else if (randVal >= 0.25 && randVal < 0.5 ) {
			Color colorEau = TypeTerrain.EAU.getColor();
			myCases.setTypeTerrain(new Terrain(0, "Terre",colorEau));
			myCases.getCanvas().setBackground(colorEau);

		}else if (randVal >= 0.5 && randVal < 0.75 ) {
			Color colorHerbe = TypeTerrain.HERBE.getColor();
			myCases.setTypeTerrain(new Terrain(0, "Terre",colorHerbe));
			myCases.getCanvas().setBackground(colorHerbe);

		}else if (randVal >= 0.75) {
			Color colorPierre = TypeTerrain.PIERRE.getColor();
			myCases.setTypeTerrain(new Terrain(0, "Terre",colorPierre));
			myCases.getCanvas().setBackground(colorPierre);

		}*/
	}
}
