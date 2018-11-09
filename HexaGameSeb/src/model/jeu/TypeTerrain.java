package model.jeu;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public enum TypeTerrain {
	
	  TERRE (new Color(Display.getDefault(), 150, 80, 40)),

	  EAU (new Color(Display.getDefault(), 42, 160, 224)),

	  HERBE (new Color(Display.getDefault(), 30, 200, 45)),

	  PIERRE (new Color(Display.getDefault(), 180, 180, 180));

	   

	  private Color color;

	   

	  //Constructeur

	  TypeTerrain(Color color){

	    this.color = color;

	  }

	  public Color getColor() {
		  
		  return color;
	  }
}
