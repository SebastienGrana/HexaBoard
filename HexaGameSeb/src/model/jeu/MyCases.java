package model.jeu;

import java.util.List;

import org.eclipse.swt.widgets.Canvas;

public class MyCases {
	
	private Integer id;
	
	private Terrain typeTerrain;
	
	private Pion pionOfCase;
	
	Canvas canvas;
	
	List<MyCases> listAdjacentBox;

	
	public MyCases() {
		super();
	}

	public MyCases(Integer id, Terrain typeTerrain, Pion pionOfCase, Canvas canvas, List<MyCases> listAdjacentBox) {
		super();
		this.id = id;
		this.typeTerrain = typeTerrain;
		this.pionOfCase = pionOfCase;
		this.canvas = canvas;
		this.listAdjacentBox = listAdjacentBox;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Terrain getTypeTerrain() {
		return typeTerrain;
	}

	public void setTypeTerrain(Terrain typeTerrain) {
		this.typeTerrain = typeTerrain;
	}

	public Pion getPionOfCase() {
		return pionOfCase;
	}

	public void setPionOfCase(Pion pionOfCase) {
		this.pionOfCase = pionOfCase;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public List<MyCases> getListAdjacentBox() {
		return listAdjacentBox;
	}

	public void setListAdjacentBox(List<MyCases> listAdjacentBox) {
		this.listAdjacentBox = listAdjacentBox;
	}

	

}
