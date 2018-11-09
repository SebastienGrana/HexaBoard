package controller.name;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Color;

import model.jeu.MyCases;
import model.jeu.Terrain;
import model.jeu.TypeTerrain;

public class BoardgameController {


	public List<MyCases> getAdjacentBox(MyCases myCases, List<List<MyCases>> boardList) {
		int nbLigne = 0;
		int nbCase = 0;
		int i = 0;
		List<MyCases> ligneAvant = new ArrayList<>();
		List<MyCases> ligneApres = new ArrayList<>();
		List<MyCases> ligneCourrante = new ArrayList<>();
		for (List<MyCases> list : boardList) {
			for (MyCases myCurrentCase : list) {

				if(myCurrentCase.equals(myCases)) {
					if(nbLigne-1 < 0) {
						ligneApres = boardList.get(nbLigne+1);
					}else if(nbLigne+1 >= boardList.size()) {
						ligneAvant = boardList.get(nbLigne-1);
					}else {
						ligneAvant = boardList.get(nbLigne-1);
						ligneApres = boardList.get(nbLigne+1);
					}
					ligneCourrante = boardList.get(nbLigne);
					System.out.println("c'est bon, ligne : "+ nbLigne +" case : " +nbCase + " id : " +  myCases.getId());
				}
				nbCase+=1;
			}
			nbLigne+=1;
		}
		List<MyCases> listAdjacentBox = setAdjacentBox(ligneCourrante,ligneAvant,ligneApres,myCases, boardList);
		// TODO Auto-generated method stub

		return listAdjacentBox;
	}



	public List<MyCases> setAdjacentBox(List<MyCases> ligneCourrante, List<MyCases> ligneAvant, List<MyCases> ligneApres, MyCases myCasesFocused, List<List<MyCases>> boardList) {
		List<MyCases> listAdjacentBox = new ArrayList<>();
		int i = 0 ;
		Integer goodIndex = -1;

		int j = 0;
		for (List<MyCases> list : boardList) {

			if(ligneCourrante.equals(list)) {
				goodIndex = j;
			}
			j+=1;
		}

		Integer id = myCasesFocused.getId();
		Integer valueOf = (id > 9 ) ? Integer.valueOf(id.toString().substring(1,2)) : id;

		if(ligneAvant.size() == 0) {
			for (MyCases myCases : ligneCourrante) {
				if(myCasesFocused.equals(myCases)) {

					if(valueOf == 0){
						MyCases caseApres = ligneCourrante.get(i+1);
						listAdjacentBox.add(caseApres);

						MyCases case2 = ligneApres.get(i);
						listAdjacentBox.add(case2);

					}else if(valueOf == 9){
						MyCases caseAvant = ligneCourrante.get(i-1);
						listAdjacentBox.add(caseAvant);

						MyCases case2 = ligneApres.get(i);
						MyCases case1 = ligneApres.get(i-1);
						listAdjacentBox.add(case1);
						listAdjacentBox.add(case2);
					}else {
						getAdjaCourrante(ligneCourrante, listAdjacentBox, i);

						MyCases case1 = ligneApres.get(i-1);
						MyCases case2 = ligneApres.get(i);

						listAdjacentBox.add(case1);
						listAdjacentBox.add(case2);
					}
				}
				i+=1;
			}
		}else if(ligneApres.size() == 0) {
			for (MyCases myCases : ligneCourrante) {
				if(myCasesFocused.equals(myCases)) {
					if(valueOf == 0){
						MyCases caseApres = ligneCourrante.get(i+1);
						listAdjacentBox.add(caseApres);

						MyCases case1  = ligneAvant.get(i);
						MyCases case2  = ligneAvant.get(i+1);

						listAdjacentBox.add(case1);
						listAdjacentBox.add(case2);

					}else if(valueOf == 9){
						MyCases caseAvant = ligneCourrante.get(i-1);
						listAdjacentBox.add(caseAvant);		

						MyCases case1  = ligneAvant.get(i);

						listAdjacentBox.add(case1);

					}else {
						getAdjaCourrante(ligneCourrante, listAdjacentBox, i);

						MyCases case1  = ligneAvant.get(i);
						MyCases case2  = ligneAvant.get(i+1);

						listAdjacentBox.add(case1);
						listAdjacentBox.add(case2);
					}
				}
				i+=1;
			}
		}else {

			for (MyCases myCases : ligneCourrante) {
				if(myCasesFocused.equals(myCases)) {
					if(goodIndex%2 == 0) {

						if(valueOf == 0){		
							MyCases caseApres = ligneCourrante.get(i+1);
							listAdjacentBox.add(caseApres);

							MyCases case2 = ligneAvant.get(i);

							listAdjacentBox.add(case2);					

							case2 = ligneApres.get(i);

							listAdjacentBox.add(case2);
						}else if(valueOf == 9){	
							MyCases caseAvant = ligneCourrante.get(i-1);
							listAdjacentBox.add(caseAvant);

							MyCases case1  = ligneAvant.get(i-1);
							MyCases case2 = ligneAvant.get(i);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);					

							case1 = ligneApres.get(i-1);
							case2 = ligneApres.get(i);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);
						}else {
							getAdjaCourrante(ligneCourrante, listAdjacentBox, i);

							MyCases case1  = ligneAvant.get(i-1);
							MyCases case2 = ligneAvant.get(i);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);					

							case1 = ligneApres.get(i-1);
							case2 = ligneApres.get(i);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);
						}

					}else {

						if(valueOf == 0){		
							MyCases caseApres = ligneCourrante.get(i+1);
							listAdjacentBox.add(caseApres);
							
							MyCases case1 = ligneAvant.get(i);
							MyCases case2 = ligneAvant.get(i+1);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);					

							case1 = ligneApres.get(i);
							case2 = ligneApres.get(i+1);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);
							
						}else if(valueOf == 9){
							MyCases caseAvant = ligneCourrante.get(i-1);
							listAdjacentBox.add(caseAvant);
							
							MyCases case1 = ligneAvant.get(i);

							listAdjacentBox.add(case1);			

							case1 = ligneApres.get(i);

							listAdjacentBox.add(case1);
						}else {
							getAdjaCourrante(ligneCourrante, listAdjacentBox, i);

							MyCases case1 = ligneAvant.get(i);
							MyCases case2 = ligneAvant.get(i+1);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);					

							case1 = ligneApres.get(i);
							case2 = ligneApres.get(i+1);

							listAdjacentBox.add(case1);
							listAdjacentBox.add(case2);
						}

					}
				}
				i+=1;
			}
		}
		return listAdjacentBox;
	}



	private void getAdjaCourrante(List<MyCases> ligneCourrante, List<MyCases> listAdjacentBox, int i) {
		MyCases caseAvant = ligneCourrante.get(i-1);
		MyCases caseApres = ligneCourrante.get(i+1);
		listAdjacentBox.add(caseAvant);
		listAdjacentBox.add(caseApres);
	}

	

}
