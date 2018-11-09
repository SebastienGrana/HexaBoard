package model.jeu;

import java.util.ArrayList;

public class Boardgame {
	
	private Integer id;
	
	private ArrayList<ArrayList<MyCases>> listOfCases;

	public Boardgame(Integer id, ArrayList<ArrayList<MyCases>> listOfCases) {
		super();
		this.id = id;
		this.listOfCases = listOfCases;
	}

	public Boardgame(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<ArrayList<MyCases>> getListOfCases() {
		return listOfCases;
	}

	public void setListOfCases(ArrayList<ArrayList<MyCases>> listOfCases) {
		this.listOfCases = listOfCases;
	}

	
	

}
