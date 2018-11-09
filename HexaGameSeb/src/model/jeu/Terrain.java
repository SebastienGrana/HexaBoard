package model.jeu;

import org.eclipse.swt.graphics.Color;

public class Terrain {
	
	private Integer id;
	
	private String name;
	private Color colorTerrain;


	
	
	public Terrain(Integer id, String name, Color colorTerrain) {
		super();
		this.id = id;
		this.name = name;
		this.colorTerrain = colorTerrain;
	}

	public Terrain(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColorTerrain() {
		return colorTerrain;
	}

	public void setColorTerrain(Color colorTerrain) {
		this.colorTerrain = colorTerrain;
	}

	

}